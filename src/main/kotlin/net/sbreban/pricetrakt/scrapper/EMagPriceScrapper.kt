package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

class EMagPriceScrapper : PriceScrapper {
  override fun getPrice(document: Document): List<Price> {
    val prices = mutableListOf<Price>()

    val newProduct = document.select(".product-new-price").first()

    if (newProduct != null) {
      val price = extractPriceValue(newProduct)
      prices.add(price)
    }

    val resealedPanel = document.select(".panel-resealed-inner").select(".product-new-price").first()

    if (resealedPanel != null) {
      val price = extractPriceValue(resealedPanel)
      prices.add(price)
    }

    return prices
  }

  private fun extractPriceValue(priceElement: Element): Price {
    val priceValue = priceElement.childNode(0).outerHtml().trim()
    val priceCurrency = priceElement.childNode(3).childNode(0).outerHtml().trim()
    return Price(price = priceValue.toDouble(), currency = priceCurrency)
  }
}