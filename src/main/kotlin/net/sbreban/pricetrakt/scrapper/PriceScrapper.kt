package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

interface PriceScrapper {
  fun getPrice(document: Document): Price

  companion object {
    fun getPriceScrapper(shop: String): PriceScrapper {
      if (shop.contains("emag")) {
        return EMagPriceScrapper()
      } else if (shop.contains("pcgarage")) {
        return PCGaragePriceScrapper()
      }
      return GenericScrapper()
    }
  }
}