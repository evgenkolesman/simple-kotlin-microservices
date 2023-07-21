package ru.koleson.serviceproducts

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import ru.koleson.serviceproducts.model.Product
import ru.koleson.serviceproducts.repository.ProductRepository
import java.math.BigDecimal
import java.util.*
import java.util.logging.Logger

@SpringBootTest
class ServiceProductsApplicationTests() {

    val log = Logger.getLogger("ServiceProductsApplicationTests")

    @Autowired
    lateinit var repo: ProductRepository

    @Test
    fun contextLoads() {

    }

    @Test
    fun testSaveMethod() {
        repo.save(Product(
            id= UUID.randomUUID(),
            name = "ANYNAME",
            description = "ANYDESC",
            price = BigDecimal.TEN,
        ))

        log.info(repo.findAll().toString())
    }
}
