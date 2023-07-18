package ru.koleson.orderservice;


import io.restassured.RestAssured
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.web.util.UriComponentsBuilder;
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Testcontainers;
import ru.koleson.orderservice.controller.dto.OrderLineItemsDTO
import ru.koleson.orderservice.controller.dto.OrderRequest
import java.math.BigDecimal
import java.util.*

import java.util.concurrent.ThreadLocalRandom;

@SpringBootTest(webEnvironment =
        SpringBootTest.WebEnvironment.DEFINED_PORT)
@Testcontainers
class IntegrationTests {

    private val url = "/api/order"

    @Test
    fun testCreateProductCorrectTest() {
    RestAssured.port = 8081;
        val toUriString = UriComponentsBuilder
                //            .fromPath(baseUrl)

                .fromPath(url)
                .build()
                .toUriString()
        given()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(OrderRequest(listOf(
                    OrderLineItemsDTO(id = UUID.randomUUID(),
                    skuCode = "SKUCODE1",
                    price = BigDecimal(10000L),
                    quantity = 1 ),
                    OrderLineItemsDTO(id = UUID.randomUUID(),
                        skuCode = "SKUCODE2",
                        price = BigDecimal(10001L),
                        quantity =2 )



                    ).toMutableList()))
            .log().all()
                .`when`()
                .post(toUriString)
                .then()
                .and().log()
                .all()
                .assertThat()
                .statusCode(200)


    }
}

val postgresDBContainers = PostgreSQLContainer("postgres:14.3-alpine")



@DynamicPropertySource
fun setProperties(dymDynamicPropertyRegistry:DynamicPropertyRegistry) {
    dymDynamicPropertyRegistry.add("spring.datasource.uri", postgresDBContainers::getJdbcUrl)
    dymDynamicPropertyRegistry.add("spring.datasource.username", postgresDBContainers::getUsername)
    dymDynamicPropertyRegistry.add("spring.datasource.password", postgresDBContainers::getPassword)
}