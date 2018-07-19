package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class PCGaragePriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): Price {
    var price = Price.genericPrice()

    val first = document.select(".ps-sell-price > span:nth-child(2)").first()
    val priceString = first.wholeText().trim()
    val priceComponents = priceString.split(" ")
    if (priceComponents.size == 2) {
      price = Price(price = priceComponents[0].replace(",", "").toDouble(), currency = priceComponents[1])
    }

    return price
  }
}