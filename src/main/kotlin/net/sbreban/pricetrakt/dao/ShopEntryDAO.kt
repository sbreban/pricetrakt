package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Price
import net.sbreban.pricetrakt.model.Product
import net.sbreban.pricetrakt.model.ShopEntry
import net.sbreban.pricetrakt.scrapper.PriceScrapper
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class ShopEntryDAO {
  private val data = mutableListOf(
      ShopEntry(productId = 1, shopId = 1,
          url = "https://www.emag.ro/telefon-mobil-lg-v30-64gb-4g-cloud-silver-lg-v30-silver/pd/DMC2VHBBM/",
          product = Product()),
      ShopEntry(productId = 1, shopId = 2,
          url = "https://www.pcgarage.ro/smartphone/lg/v30-ecran-quad-hd-plus-gorilla-glass-5-snapdragon-835-245-ghz-octa-core-64gb-4gb-ram-single-sim-4g-tri-camera-16-plus-13-mpx-plus-5-mpx-quick-charge-30-cloud-silver/",
          product = Product()),
      ShopEntry(productId = 3, shopId = 1,
          url = "https://www.emag.ro/telefon-mobil-huawei-p20-lite-dual-sim-64gb-4g-klein-blue-p20-lite-anne-l21-blue/pd/D6V1PFBBM/",
          product = Product())
  )

  fun getEntriesForProduct(productId: Int) =
      data.filter { shopEntry -> shopEntry.productId == productId }

  fun getPricesForProduct(productId: Int): MutableList<Price> {
    val entriesForProduct = getEntriesForProduct(productId)
    val prices = mutableListOf<Price>()
    entriesForProduct.forEach {
      var price = Price.genericPrice()
      Jsoup.connect(it.url).get().run {
        val priceScrapper = PriceScrapper.getPriceScrapper(it.url)
        price = priceScrapper.getPrice(this)
      }
      prices.add(price)
    }
    return prices
  }
}