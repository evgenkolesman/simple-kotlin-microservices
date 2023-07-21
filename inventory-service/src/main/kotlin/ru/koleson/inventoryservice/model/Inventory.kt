package ru.koleson.inventoryservice.model

import jakarta.persistence.*


@Entity
@Table(name = "t_inventory")
class Inventory(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long = -1L,
    var skuCode: String = "",
    var quantity: Int = -1
    )
