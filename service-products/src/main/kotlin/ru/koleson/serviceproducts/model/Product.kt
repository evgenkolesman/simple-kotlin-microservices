package ru.koleson.serviceproducts.model

import ru.koleson.serviceproducts.controller.dto.ProductRequest
import ru.koleson.serviceproducts.controller.dto.ProductResponse
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.UUID

@Document(value = "product")
data class Product(
    @Id
    var id : UUID = UUID.randomUUID(),
    var name: String,
    var description: String,
    var price : BigDecimal

) {

    fun toProductResponse() : ProductResponse = ProductResponse(id, name, description, price)
    fun toProductRequest() : ProductRequest = ProductRequest(name, description, price)
}
