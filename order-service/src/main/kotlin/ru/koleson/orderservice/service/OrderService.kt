package ru.koleson.orderservice.service

import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.repository.OrderRepository


@Service
class OrderService(val orderRepository: OrderRepository) {

    fun createOrder(order: Order) {

        orderRepository.save(order)
//        order
//            .getOrderLineItems()
//            .forEach{olt -> orderRepository
//                .insertOrder(order.id, order.getOrderNumber(), olt.id)}
    }

}
