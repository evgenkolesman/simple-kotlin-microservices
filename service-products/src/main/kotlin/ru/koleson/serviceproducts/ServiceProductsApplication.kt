package ru.koleson.serviceproducts

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ServiceProductsApplication

fun main(args: Array<String>) {
    runApplication<ServiceProductsApplication>(*args)
}
