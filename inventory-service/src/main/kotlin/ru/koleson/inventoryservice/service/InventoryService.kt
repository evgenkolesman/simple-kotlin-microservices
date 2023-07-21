package ru.koleson.inventoryservice.service

import ru.koleson.inventoryservice.repository.InventoryRepository

class InventoryService(val inventoryRepository: InventoryRepository) {
    fun isInStock(skuCode: List<String>): Any {

    }

}
