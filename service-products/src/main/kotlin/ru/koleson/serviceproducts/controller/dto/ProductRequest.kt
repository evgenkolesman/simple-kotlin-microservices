package ru.koleson.serviceproducts.controller.dto

import java.math.BigDecimal


 class ProductRequest(
    val name: String = "",
    val description: String = "",
    val price: BigDecimal = BigDecimal.ZERO
) {


 }
