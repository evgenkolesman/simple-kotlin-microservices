package ru.koleson.inventoryservice.model

import jakarta.persistence.*


@Entity
@Table(name = "t_inventory")
class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    var id:Long = -1L,
    @Column(name = "sku_code")
    var skuCode: String = "",
    @Column(name = "quantity")
    var quantity: Int = -1
    )
