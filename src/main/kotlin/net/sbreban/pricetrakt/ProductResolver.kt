package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductResolver(private val productDAO: ProductDAO
) : GraphQLResolver<Product> {

  fun shopEntries(product: Product) = getEntriesForProduct(product.id)

  fun getEntriesForProduct(productId: Int) =
      productDAO.getOne(productId).shopEntries
}