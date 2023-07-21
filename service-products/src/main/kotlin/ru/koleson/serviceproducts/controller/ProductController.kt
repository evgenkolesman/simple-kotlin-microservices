package ru.koleson.serviceproducts.controller

import ru.koleson.serviceproducts.controller.dto.ProductRequest
import ru.koleson.serviceproducts.controller.dto.ProductResponse
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.koleson.serviceproducts.service.ProductService

@RestController
@RequestMapping("/api/product")
class ProductController(val productService: ProductService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun createProduct(@RequestBody productRequest: ProductRequest) = productService.createProduct(productRequest)

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    fun getAllProducts(): List<ProductResponse> = productService
        .getAllProducts()
        .map { product -> product.toProductResponse() }
}