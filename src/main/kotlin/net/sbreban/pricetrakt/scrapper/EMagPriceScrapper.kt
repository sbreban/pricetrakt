package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class EMagPriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): Price {
    var price = Price.genericPrice()

    val first = document.select(".product-new-price").first()

    if (first != null) {
      val priceValue = first.childNode(0).outerHtml().trim()
      val priceCurrency = first.childNode(3).childNode(0).outerHtml().trim()
      price = Price(price = priceValue.toDouble(), currency = priceCurrency)
    }

    return price
  }
}