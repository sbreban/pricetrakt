package net.sbreban.pricetrakt.scrapper

import net.sbreban.pricetrakt.dao.PriceDAO
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.dao.ShopEntryDAO
import net.sbreban.pricetrakt.model.Product
import net.sbreban.pricetrakt.model.ShopEntry
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class ScrapperRunner(val productDAO: ProductDAO, val priceDAO: PriceDAO, val shopEntryDAO: ShopEntryDAO) {

  fun run() {
    val products = productDAO.findAll()
    products.forEach {
      getPricesForProduct(it)
    }
    priceDAO.flush()
    shopEntryDAO.flush()
  }

  fun getPricesForProduct(product: Product) {
    val entriesForProduct = product.shopEntries
    entriesForProduct.forEach { shopEntry ->
      scrapPrices(shopEntry)
    }
  }

  private fun scrapPrices(shopEntry: ShopEntry) {
    try {
      Jsoup.connect(shopEntry.url).get().run {
        val priceScrapper = PriceScrapper.getPriceScrapper(shopEntry.url)
        val currentPrices = priceScrapper.getPrice(this)

        println("Scrapper prices $currentPrices for URL ${shopEntry.url}")

        currentPrices.forEach { price ->
          shopEntry.addPrice(price)
          priceDAO.save(price)
        }
        shopEntryDAO.save(shopEntry)
      }
    } catch (e: Exception) {
      println("${e.message} for ${shopEntry.url}")
    }
  }
}