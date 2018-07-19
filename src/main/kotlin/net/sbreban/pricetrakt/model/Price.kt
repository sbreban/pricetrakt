package net.sbreban.pricetrakt.model

data class Price(
    val price: Double,
    val currency: String
) {
  companion object {
    fun genericPrice(): Price {
      return Price(price = 0.0, currency = "Lei")
    }
  }
}