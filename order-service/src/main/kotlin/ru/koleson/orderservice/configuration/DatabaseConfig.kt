package ru.koleson.orderservice.configuration

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.transaction.PlatformTransactionManager
import javax.sql.DataSource

@Configuration
@EnableJdbcRepositories("ru.koleson.orderservice")
class DatabaseConfig(val dataSource: DataSource) {

    @Bean
    fun namedParameterJdbcTemplate(dataSource: DataSource) = NamedParameterJdbcTemplate(dataSource)

    @Bean
    fun transactionManager(dataSource: DataSource): PlatformTransactionManager = DataSourceTransactionManager(dataSource)
}