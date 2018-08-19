package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.model.Price
import org.jsoup.nodes.Document

class GenericScrapper : PriceScrapper {
  override fun getPrice(document: Document): List<Price> {
    return mutableListOf(Price.genericPrice())
  }
}