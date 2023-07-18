package ru.koleson.orderservice.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import ru.koleson.orderservice.controller.dto.OrderRequest
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.model.OrderLineItems
import ru.koleson.orderservice.repository.OrderLineItemsRepository
import ru.koleson.orderservice.service.OrderService
import java.time.LocalDateTime
import java.util.*

@RestController
@RequestMapping("/api/order")
class OrderController(val orderService: OrderService,
    val orderLineItems: OrderLineItemsRepository) {


    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    fun placeOrder(@RequestBody orderRequest : OrderRequest) :String {

        val order = Order(
            id = UUID.randomUUID(),
            orderNumber = LocalDateTime.now().toString(),
            orderLineItems = orderRequest.orderLineItemsDTOs.map { order -> order.toOrderLineItems() }
        )

//            orderLineItems = orderRequest
//                .orderLineItemsDTOs
//                .map { orderLineItemsDTO ->  orderLineItemsDTO.toOrderLineItems() }.toMutableList()


        orderService.createOrder(order)
       return "Order Place Succesfully"
    }
}