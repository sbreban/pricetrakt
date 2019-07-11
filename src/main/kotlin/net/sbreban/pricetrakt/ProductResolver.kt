package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.dao.ShopEntryDAO
import net.sbreban.pricetrakt.model.Price
import net.sbreban.pricetrakt.model.Product
import net.sbreban.pricetrakt.scrapper.PriceScrapper
import org.jsoup.Jsoup
import org.springframework.stereotype.Component

@Component
class ProductResolver(private val productDAO: ProductDAO
) : GraphQLResolver<Product> {

  fun getEntriesForProduct(productId: Int) =
      productDAO.getOne(productId).shopEntries

  fun getPricesForProduct(productId: Int): MutableList<Price> {
    val entriesForProduct = getEntriesForProduct(productId)
    val prices = mutableListOf<Price>()
    entriesForProduct.forEach {
      Jsoup.connect(it.url).get().run {
        val priceScrapper = PriceScrapper.getPriceScrapper(it.url)
        prices.addAll(priceScrapper.getPrice(this))
      }
    }
    return prices
  }

  fun shopEntries(product: Product) = getEntriesForProduct(product.id)
  fun prices(product: Product) = getPricesForProduct(product.id)
}