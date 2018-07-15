package net.sbreban.pricetrakt

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import net.sbreban.pricetrakt.dao.ProductDAO
import org.springframework.stereotype.Component

@Component
class ProductQueryResolver(
        private val productDAO: ProductDAO
) : GraphQLQueryResolver {
  fun getProductById(id: String) = productDAO.getProductById(id)
}