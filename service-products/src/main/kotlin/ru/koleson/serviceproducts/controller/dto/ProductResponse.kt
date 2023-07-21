package ru.koleson.serviceproducts.controller.dto

import java.math.BigDecimal
import java.util.UUID

data class ProductResponse(
    val id: UUID,
    val name: String,
    val description: String,
    val price: BigDecimal
)
