package ru.koleson.inventoryservice.service

import org.springframework.stereotype.Service
import ru.koleson.inventoryservice.model.InventoryResponse
import ru.koleson.inventoryservice.repository.InventoryRepository
import java.util.logging.Logger

@Service
class InventoryService(val inventoryRepository: InventoryRepository) {
    val log = Logger.getLogger("InventoryService")
    fun isInStock(skuCodes: List<String>) : List<InventoryResponse> =
        skuCodes
            .map { skuCode ->
                    InventoryResponse(
                        skuCode,
                        inventoryRepository.existsBySkuCode(skuCode)
                    )
             }

}
