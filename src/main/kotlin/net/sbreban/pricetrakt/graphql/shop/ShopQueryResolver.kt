package net.sbreban.pricetrakt.graphql.shop

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import net.sbreban.pricetrakt.dao.ShopDAO
import net.sbreban.pricetrakt.model.Shop
import org.springframework.stereotype.Component

@Component
class ShopQueryResolver(
    private val shopDAO: ShopDAO
) : GraphQLQueryResolver {
  fun shops(id: Int): List<Shop> {
    if (id <= 0) {
      return shopDAO.findAll()
    } else {
      val shop = shopDAO.findAll().findLast { shop -> shop.id == id }
      if (shop != null) {
        return listOf(shop)
      }
    }
    return emptyList()
  }
}