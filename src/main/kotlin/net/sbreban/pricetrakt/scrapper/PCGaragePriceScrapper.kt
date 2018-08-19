package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class PCGaragePriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): List<Price> {
    var price = Price()

    val priceElement = document.select(".ps-sell-price").first()

    if (priceElement != null) {
      val priceValueElement = priceElement.select("meta:nth-child(3)")
      val priceCurrencyElement = priceElement.select("meta:nth-child(4)")

      val priceValue = priceValueElement.attr("content").toDouble()
      val priceCurrency = priceCurrencyElement.attr("content")

      price = Price(price = priceValue, currency = priceCurrency)
    }

    return mutableListOf(price)
  }
}