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
    fun isInStock(@RequestParam(name = "skuCode") skuCode: List<String>): List<InventoryResponse> =
        inventoryService.isInStock(skuCode)
}