package ru.koleson.orderservice.controller.dto

import ru.koleson.orderservice.model.OrderLineItems

data class OrderRequest(val orderLineItemsDTOs : MutableList<OrderLineItemsDTO>) {
}