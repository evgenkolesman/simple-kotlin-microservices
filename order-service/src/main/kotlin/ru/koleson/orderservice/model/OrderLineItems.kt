package ru.koleson.orderservice.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal
import java.util.UUID

@Table("order_line_items")
class OrderLineItems(
    @Id
    @Column("id")
    var id: UUID,
    @Column("skucode")
    var skuCode: String ,
    @Column("price")
    var price: BigDecimal,
    @Column("quantity")
    var quantity: Int
)
