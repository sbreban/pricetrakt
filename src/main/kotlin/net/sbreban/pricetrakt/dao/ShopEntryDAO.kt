package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.ShopEntry
import org.springframework.stereotype.Component

@Component
class ShopEntryDAO {
  private val data = mutableListOf(
          ShopEntry(productId = "v30", shopId = "emag", price = 2600),
          ShopEntry(productId = "v30", shopId = "pcgarage", price = 2800)
  )

  fun getEntriesForProduct(productId: String) =
          data.filter { shopEntry -> shopEntry.productId == productId }
}