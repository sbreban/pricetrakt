package net.sbreban.pricetrakt.model

data class Price(
    val price: Double = 0.0,
    val currency: String = "",
    val state: ProductState = ProductState.NEW
)