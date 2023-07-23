package ru.koleson.orderservice.service

import org.springframework.stereotype.Service
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.util.UriComponentsBuilder
import ru.koleson.orderservice.model.Order
import ru.koleson.orderservice.repository.OrderRepository
import java.net.URI
import java.util.logging.Logger


@Service
class OrderService(
    val orderRepository: OrderRepository,
    val webClient: WebClient
) {
    val log = Logger.getLogger("OrderService")

    val INVENTORY = "http://localhost/api/inventory"

    //TODO http://localhost:8082/api/inventory?skuCode=SKUCODE1&skuCode=SKUCODE2 need to do like that

    fun createOrder(order: Order) {

        val list: List<String> = order.getOrderLineItems().map { oLI -> oLI.getSkuCode() }
        val params  =  LinkedMultiValueMap<String, String>()
        list.map { ordeLineItem -> params.put("skuCode", list) }


        val all = webClient.get()
            .uri(
                UriComponentsBuilder.newInstance()
                    .uri(URI.create(INVENTORY))
                    .port(8082)
                    .queryParams(params)
                    .build()
                    .toUriString()
            )
            .retrieve()
            .bodyToMono<List<InventoryResponse>>()
            .blockOptional()
            .get()
            .all { ar -> ar.isInStock }

            if (all)  orderRepository.save(order)
            else log.info("This order does not exists $order")
    }
}


class InventoryResponse(var skuCode: String = "", var isInStock: Boolean = false) {

}

