package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class EMagPriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): Price {
    var price = Price.genericPrice()

    val first = document.select(".product-page-pricing > p:nth-child(2)").first()
    val priceString = first.wholeText().trim()
    val priceComponents = priceString.split(" ")
    if (priceComponents.size == 2) {
      price = Price(price = priceComponents[0].toDouble(), currency = priceComponents[1])
    }

    return price
  }
}