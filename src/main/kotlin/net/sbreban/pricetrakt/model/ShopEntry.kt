package net.sbreban.pricetrakt.model

import javax.persistence.*

@Entity
@Table(name = "shop_entries")
data class ShopEntry(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    val shop: Shop = Shop(),

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    var product: Product = Product(),

    val url: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shopEntry")
    val prices: MutableList<Price> = mutableListOf()
) {
  fun addPrice(price: Price) {
    price.shopEntry = this
    prices.add(price)
  }
}