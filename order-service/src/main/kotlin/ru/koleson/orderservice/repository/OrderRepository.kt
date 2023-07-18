package ru.koleson.orderservice.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.model.OrderLineItems
import java.util.*

interface OrderRepository : CrudRepository<Order, UUID> {

    @Query("""

        INSERT INTO public.order_line_items(id, skucode, price, quantity)
        VALUES (:id, :skucode, :price, :quantity)
        INSERT INTO public.orders_table(id, order_number, order_line_items_id)
         VALUES (:id, :order_number, :order_line_items_id)

    """)
    fun insertOrder(order: Order)
}