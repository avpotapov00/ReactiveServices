package info.potapov.reactiveservices.view

import java.util.UUID


data class GoodView(
    val id: UUID,
    val name: String,
    val price: Double
)