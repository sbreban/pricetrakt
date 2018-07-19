package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductDAO {
  private val data = mutableListOf(
      Product(id = "v30", name = "LG V30"),
      Product(id = "7plus", name = "Nokia 7 Plus"),
      Product(id = "p20lite", name = "Huawei P20 Lite")
  )

  fun getProductById(id: String) = data.firstOrNull { product -> product.id == id }
}