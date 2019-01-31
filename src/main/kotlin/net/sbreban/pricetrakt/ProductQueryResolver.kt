package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(
    private val productDAO: ProductDAO
) : GraphQLQueryResolver {
  fun products(id: Int): List<Product> {
    val products: List<Product>
    if (id <= 0) {
      products = productDAO.findAll()
    } else {
      products = listOf(productDAO.getOne(id))
    }
    return products
  }
}