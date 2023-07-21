package ru.koleson.serviceproducts.repository

import ru.koleson.serviceproducts.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, String> {
}