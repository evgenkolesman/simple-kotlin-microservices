package ru.koleson.orderservice.controller.dto

import ru.koleson.orderservice.model.OrderLineItems
import ru.koleson.orderservice.model.ofOrderLineItems
import java.math.BigDecimal
import java.util.UUID

class OrderLineItemsDTO(
    val id: UUID,
    val skuCode: String,
    val price: BigDecimal,
    val quantity: Int
) {

   fun toOrderLineItems() : OrderLineItems = ofOrderLineItems(
        id = this.id,
        skuCode = this.skuCode,
        price = this.price,
        quantity = this.quantity
    )
}