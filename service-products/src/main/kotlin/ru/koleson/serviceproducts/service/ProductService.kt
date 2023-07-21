package ru.koleson.serviceproducts.service

import ru.koleson.serviceproducts.exceptions.CreatedException
import ru.koleson.serviceproducts.model.Product
import ru.koleson.serviceproducts.controller.dto.ProductRequest
import org.springframework.stereotype.Service
import ru.koleson.serviceproducts.repository.ProductRepository
import java.lang.Exception
import java.util.logging.Logger

@Service
class ProductService(val productRepository: ProductRepository) {
    val logger = Logger.getLogger(this.javaClass.name)

    fun createProduct(productRequest: ProductRequest): Product {
        try {
            val save = productRepository.save(
                Product(
                    name = productRequest.name,
                    description = productRequest.description,
                    price = productRequest.price
                )
            )
            logger.info("Product created $save")
            return save
        } catch ( e: Exception) {
            logger.info(e.localizedMessage)
            throw CreatedException(e.localizedMessage)
        }
    }

    fun getAllProducts():List<Product> = productRepository.findAll()


}