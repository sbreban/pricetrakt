package net.sbreban.pricetrakt.scrapper

import org.jsoup.Jsoup
import org.junit.Assert
import org.junit.jupiter.api.Test
import org.springframework.core.io.ClassPathResource

internal class EMagPriceScrapperTest {

  private val priceScrapper = EMagPriceScrapper()

  @Test
  internal fun testPrice() {
    val document = Jsoup.parse(ClassPathResource("emag.html").inputStream, Charsets.UTF_8.name(), "")
    val price = priceScrapper.getPrice(document)
    Assert.assertEquals(2, price.size)
    Assert.assertEquals(1.299, price[0].price, 0.01)
    Assert.assertEquals(1.169, price[1].price, 0.01)
  }
}