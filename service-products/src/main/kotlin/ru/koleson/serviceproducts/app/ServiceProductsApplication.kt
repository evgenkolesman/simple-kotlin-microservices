package ru.koleson.serviceproducts.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@SpringBootApplication
@EnableEurekaClient
class ServiceProductsApplication

fun main(args: Array<String>) {
    runApplication<ServiceProductsApplication>(*args)
}
