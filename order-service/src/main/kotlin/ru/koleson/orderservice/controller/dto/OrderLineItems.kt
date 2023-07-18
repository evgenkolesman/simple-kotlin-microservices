package ru.koleson.orderservice.controller.dto

import ru.koleson.orderservice.model.OrderLineItems
import java.math.BigDecimal
import java.util.UUID

class OrderLineItemsDTO(
    val id: UUID,
    val skuCode: String,
    val price: BigDecimal,
    val quantity: Int
) {

   fun toOrderLineItems() = OrderLineItems(
        id = this.id,
        skuCode = this.skuCode,
        price = this.price,
        quantity = this.quantity
    )
}