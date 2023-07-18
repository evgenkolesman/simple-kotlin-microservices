package ru.koleson.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.util.*

@Table("orders_table")
data class Order(
    @Id
    @Column("id")
    private var id: UUID,
    @Column("order_number")
    private var orderNumber: String,

    @Column("order_line_items_id")
    @MappedCollection(idColumn = "id", keyColumn = "id")
    private var orderLineItems: MutableList<OrderLineItems>
) : AbstractEntity() {

    override fun getId(): UUID = this.id
    fun getOrderNumber() = this.orderNumber
    fun getOrderLineItems() = this.orderLineItems

    fun addOrderLineItems(orderLineItems: OrderLineItems) {
        orderLineItems.id = UUID.randomUUID()

    }

}


