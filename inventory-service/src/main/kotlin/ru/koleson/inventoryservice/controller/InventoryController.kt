package ru.koleson.inventoryservice.controller

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import ru.koleson.inventoryservice.model.InventoryResponse
import ru.koleson.inventoryservice.service.InventoryService

@RestController
@RequestMapping("/api/inventory")
class InventoryController(val inventoryService: InventoryService) {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    // http://localhost:8082/api/inventory/iphone-13,iphone13-red
    fun isInStock(@RequestParam skuCode: List<String>): List<InventoryResponse> = inventoryService.isInStock(skuCode)
}