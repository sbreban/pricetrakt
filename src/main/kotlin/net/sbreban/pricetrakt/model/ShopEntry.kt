package net.sbreban.pricetrakt.model

import javax.persistence.*

@Entity
@Table(name = "shop_entries")
data class ShopEntry(

    @Id
    val id: Int = 0,

    @Column(name = "product_id")
    val productId: Int = 0,

    @Id
    @Column(name = "shop_id")
    val shopId: Int = 0,

    val url: String = "",

    @ManyToOne
    val product: Product = Product()
)