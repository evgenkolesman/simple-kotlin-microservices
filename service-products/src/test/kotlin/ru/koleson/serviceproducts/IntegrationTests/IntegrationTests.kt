package ru.koleson.serviceproducts.IntegrationTests

import com.fasterxml.jackson.databind.ObjectMapper
import io.restassured.RestAssured.given
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.web.util.UriComponentsBuilder
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.junit.jupiter.Testcontainers
import ru.koleson.serviceproducts.controller.dto.ProductRequest
import java.math.BigDecimal
import java.util.concurrent.ThreadLocalRandom

@SpringBootTest(webEnvironment =
SpringBootTest.WebEnvironment.DEFINED_PORT)
@Testcontainers
//@AutoConfigureMockMvc
//@ContextConfiguration(initializers = [Initializer::class])
class IntegrationTests {

//    @Autowired
//    private lateinit var mockMvc: MockMvc


    val url = "/api/product"
    val baseUrl = "http://localhost"

//    @BeforeEach
//    fun setUp() {
//        RestAssured.port = 8080
//    }

    @Test
    fun testCreateProductCorrectTest() {
        val name = "NAME" + ThreadLocalRandom.current().ints(1, 101)
        val description = "DESCRIPTION" + ThreadLocalRandom.current().ints(1, 101)
        val price = BigDecimal(
            ThreadLocalRandom.current()
                .longs(1000000)
                .findFirst()
                .orElse(1L)
        )
        val toUriString = UriComponentsBuilder
            //            .fromPath(baseUrl)
            //            .port(port)
            .fromPath(url)
            .build()
            .toUriString()
        given()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(ProductRequest(name = name, description = description, price = price))
            .`when`()
            .post(toUriString)
            .then()
            .and().log()
            .all()
            .assertThat()
            .statusCode(201)


    }

}

    /*
    @Test
    fun mockCreateProductCorrectTest() {
        val name = "NAME" + ThreadLocalRandom.current().ints(1, 101)
        val description = "DESCRIPTION" + ThreadLocalRandom.current().ints(1, 101)
        val price = BigDecimal(
            ThreadLocalRandom.current()
                .longs(1000000)
                .findFirst()
                .orElse(1L)
        )

        mockMvc
            .perform(
                MockMvcRequestBuilders.post(url)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(
                        objectMapper
                            .writeValueAsString(ProductRequest(name = name,
                                description = description,
                                price = price))
                    )
            )
            .andExpect(status()
                .isCreated())

    }

}
*/
val mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:6.0.3")
@DynamicPropertySource
fun setProperties(dymDynamicPropertyRegistry: DynamicPropertyRegistry) =
    dymDynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl)


//class Initializer: ApplicationContextInitializer<ConfigurableApplicationContext>
// {
//    val mongoDBContainer: MongoDBContainer = MongoDBContainer("mongo:6.0.3")
//
//    override fun initialize(applicationContext: ConfigurableApplicationContext) {
//        mongoDBContainer.start()
//        TestPropertyValues.of(
//               "spring.data.mongodb.host=" + mongoDBContainer.getHost(),
//            "spring.data.mongodb.port=" + mongoDBContainer.getFirstMappedPort(),
//            "spring.data.mongodb.url=" + mongoDBContainer.getReplicaSetUrl()
//        ).applyTo(applicationContext)
//    }

