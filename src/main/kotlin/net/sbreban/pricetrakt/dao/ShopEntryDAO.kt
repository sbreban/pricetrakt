package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Price
import net.sbreban.pricetrakt.model.ShopEntry
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class ShopEntryDAO {
  private val data = mutableListOf(
      ShopEntry(productId = "v30", shopId = "emag",
          url = "https://www.emag.ro/telefon-mobil-lg-v30-64gb-4g-cloud-silver-lg-v30-silver/pd/DMC2VHBBM/"),
      ShopEntry(productId = "v30", shopId = "pcgarage",
          url = "https://www.pcgarage.ro/smartphone/lg/v30-ecran-quad-hd-plus-gorilla-glass-5-snapdragon-835-245-ghz-octa-core-64gb-4gb-ram-single-sim-4g-tri-camera-16-plus-13-mpx-plus-5-mpx-quick-charge-30-cloud-silver/")
  )

  fun getEntriesForProduct(productId: String) =
      data.filter { shopEntry -> shopEntry.productId == productId }

  fun getPricesForProduct(productId: String): MutableList<Price> {
    val entriesForProduct = getEntriesForProduct(productId)
    val prices = mutableListOf<Price>()
    entriesForProduct.forEach {
      var price = Price(price = 23.0, currency = "Lei")
      Jsoup.connect(it.url).get().run {
        if (it.url.contains("emag")) {
          val first = select(".product-page-pricing > p:nth-child(2)").first()
          val priceString = first.wholeText().trim()
          val priceComponents = priceString.split(" ")
          if (priceComponents.size == 2) {
            price = Price(price = priceComponents[0].toDouble(), currency = priceComponents[1])
          }
        } else if (it.url.contains("pcgarage")) {
          val first = select(".ps-sell-price > span:nth-child(2)").first()
          val priceString = first.wholeText().trim()
          val priceComponents = priceString.split(" ")
          if (priceComponents.size == 2) {
            price = Price(price = priceComponents[0].replace(",", "").toDouble(), currency = priceComponents[1])
          }
        }
      }
      prices.add(price)
    }
    return prices
  }
}