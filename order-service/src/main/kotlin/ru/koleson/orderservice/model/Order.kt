package ru.koleson.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.*
import java.util.*
import kotlin.collections.Set

@Table("orders_table")
data class Order(
    @Id
    @Column("id")
    private var id: UUID,
    @Column("order_number")
    private var orderNumber: String,
    @MappedCollection(idColumn = "order_id", keyColumn = "id")
    private var orderLineItems: List<OrderLineItems>


//    @MappedCollection(idColumn = "id", keyColumn = "id")
//    private var orderLineItems: MutableList<OrderLineItems>
) : AbstractEntity() {

    override fun getId(): UUID = this.id
    fun getOrderNumber() = this.orderNumber
//    fun getOrderLineItems() = this.orderLineItems

//    fun addOrderLineItems(orderLineItems: OrderLineItems) {
//        orderLineItems.se = UUID.randomUUID()
//
//    }

}


