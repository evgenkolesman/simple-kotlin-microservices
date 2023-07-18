package ru.koleson.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.MappedCollection
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.util.UUID

@Table("order_line_items")
class OrderLineItems(
    @Id
    @Column("id")
    private var id: UUID,
    @Column("skucode")
    private var skuCode: String ,
    @Column("price")
    private var price: BigDecimal,
    @Column("quantity")
    private var quantity: Int,

) : AbstractEntity() {
    override fun getId() = this.id


}
fun ofOrderLineItems(id: UUID, skuCode: String, price: BigDecimal, quantity: Int) : OrderLineItems  =
    OrderLineItems(id = id,
        skuCode = skuCode,
        price = price,
        quantity= quantity
    )

