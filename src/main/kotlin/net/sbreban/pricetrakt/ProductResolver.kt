package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLResolver
import net.sbreban.pricetrakt.dao.ShopEntryDAO
import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductResolver(private val shopEntryDAO: ShopEntryDAO) : GraphQLResolver<Product> {
  fun shopEntries(product: Product) = shopEntryDAO.getEntriesForProduct(product.id)
}