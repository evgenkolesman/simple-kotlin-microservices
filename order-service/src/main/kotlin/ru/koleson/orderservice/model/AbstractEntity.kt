package ru.koleson.orderservice.model

import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import java.util.*

abstract class AbstractEntity : Persistable<UUID> {

    @Transient
    private var isNew = true

    override fun isNew(): Boolean = isNew

    fun markNotNew() =
        false.also { this.isNew = it }


}