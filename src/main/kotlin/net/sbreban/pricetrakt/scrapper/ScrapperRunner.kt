package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.dao.PriceDAO
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.dao.ShopEntryDAO
import net.sbreban.pricetrakt.model.Product
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class ScrapperRunner(val productDAO: ProductDAO, val priceDAO: PriceDAO, val shopEntryDAO: ShopEntryDAO) {

  fun run() {
    val products = productDAO.findAll()
    products.forEach {
      getPricesForProduct(it)
    }
  }

  fun getPricesForProduct(product: Product) {
    val entriesForProduct = product.shopEntries
    entriesForProduct.forEach { shopEntry ->
      try {
        Jsoup.connect(shopEntry.url).get().run {
          val priceScrapper = PriceScrapper.getPriceScrapper(shopEntry.url)
          val currentPrices = priceScrapper.getPrice(this)

          println("Scrapper prices $currentPrices for URL ${shopEntry.url}")

          currentPrices.forEach { price ->
            price.shopEntry = shopEntry
            priceDAO.saveAndFlush(price)
          }
        }
        shopEntryDAO.saveAndFlush(shopEntry)
      } catch (e: Exception) {
        println("${e.message} for ${shopEntry.url}")
      }
    }
  }
}