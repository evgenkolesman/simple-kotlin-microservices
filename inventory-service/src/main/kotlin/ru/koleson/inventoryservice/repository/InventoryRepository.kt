package ru.koleson.inventoryservice.repository

import org.springframework.data.jpa.repository.JpaRepository
import ru.koleson.inventoryservice.model.Inventory

interface InventoryRepository: JpaRepository<Inventory, Long> {

    fun existsBySkuCode(skuCode:String):Boolean

}
