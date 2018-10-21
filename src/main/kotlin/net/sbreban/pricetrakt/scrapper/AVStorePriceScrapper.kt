package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class AVStorePriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): List<Price> {
    var price = Price()

    val priceElement = document.select("span.pret").first()

    if (priceElement != null) {
      val priceValueElement = priceElement.select("span.pret-nou.number")
      val priceCurrencyElement = priceElement.select("span.moneda > span")

      val priceValue = priceValueElement.text().toDouble()
      val priceCurrency = priceCurrencyElement.text()

      price = Price(price = priceValue, currency = priceCurrency)
    }

    return mutableListOf(price)
  }
}