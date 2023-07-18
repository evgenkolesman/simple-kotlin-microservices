package ru.koleson.orderservice.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.model.OrderLineItems
import java.util.*

interface OrderLineItemsRepository : CrudRepository<OrderLineItems, UUID> {

}