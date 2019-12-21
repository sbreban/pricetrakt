package net.sbreban.pricetrakt.scrapper

import org.jsoup.Jsoup
import org.junit.Assert.assertEquals
import org.junit.jupiter.api.Test

internal class AVStorePriceScrapperTest {

  private val priceScrapper = AVStorePriceScrapper()

  @Test
  fun testPrice() {
    val document = Jsoup.parse(this::class.java.getResourceAsStream("avstore.html"), Charsets.UTF_8.name(), "")
    val price = priceScrapper.getPrice(document)
    assertEquals(1, price.size)
    assertEquals(299.0, price[0].price, 0.01)
  }
}