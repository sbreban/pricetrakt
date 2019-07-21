package net.sbreban.pricetrakt.model

import javax.persistence.*
import javax.persistence.FetchType

@Entity
@Table(name = "products")
data class Product(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,

    val name: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product", orphanRemoval = true)
    val shopEntries: MutableList<ShopEntry> = mutableListOf()
) {
  fun addShopEntry(shopEntry: ShopEntry) {
    shopEntry.product = this
    shopEntries.add(shopEntry)
  }
}