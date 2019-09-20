package net.sbreban.pricetrakt.graphql

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(
    private val productDAO: ProductDAO
) : GraphQLQueryResolver {
  fun products(id: Int): List<Product> {
    if (id <= 0) {
      return productDAO.findAll()
    } else {
      val product = productDAO.findAll().findLast { product -> product.id == id }
      if (product != null) {
        return listOf(product)
      }
    }
    return emptyList()
  }
}