package ru.koleson.orderservice.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.QueryMappingConfiguration
import org.springframework.data.jdbc.repository.config.DefaultQueryMappingConfiguration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.model.OrderLineItems
import java.sql.ResultSet
import java.util.UUID
import javax.sql.DataSource


@Configuration
@EnableJdbcRepositories("ru.koleson.orderservice")
class DatabaseConfig(val dataSource: DataSource) {

    @Bean
    fun namedParameterJdbcTemplate(dataSource: DataSource) = NamedParameterJdbcTemplate(dataSource)

    @Bean
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager = DataSourceTransactionManager(dataSource)

    @Bean
    fun rowMappers(): QueryMappingConfiguration {
        return DefaultQueryMappingConfiguration()
            .registerRowMapper(Order::class.java, BeanPropertyRowMapper.newInstance(Order::class.java))
            .registerRowMapper(OrderLineItems::class.java, BeanPropertyRowMapper.newInstance(OrderLineItems::class.java))

    }
}

//class OrderMapper : RowMapper<Order> {
//    override fun mapRow(rs: ResultSet, rowNum: Int): Order {
//        Order(rs.getObject(1, UUID::class.java),
//            rs.getString(2),
//            rs.getObject(3, UUID::class.java))
//
//    }
//}