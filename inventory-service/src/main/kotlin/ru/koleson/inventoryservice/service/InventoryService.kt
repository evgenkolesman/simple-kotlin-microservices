package ru.koleson.inventoryservice.service

import org.springframework.stereotype.Service
import ru.koleson.inventoryservice.model.InventoryResponse
import ru.koleson.inventoryservice.repository.InventoryRepository

@Service
class InventoryService(val inventoryRepository: InventoryRepository) {
    fun isInStock(skuCodes: List<String>) =
        skuCodes
            .map { skuCode -> InventoryResponse(skuCode,
                inventoryRepository.existsBySkuCode(skuCode)) }

}
