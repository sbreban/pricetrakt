package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(
    private val productDAO: ProductDAO
) : GraphQLQueryResolver {
  fun getProductById(id: Int) = productDAO.getOne(id)
  fun getProductByName(name: String) = productDAO.findByName(name)
  fun getAllProducts() = productDAO.findAll()
}