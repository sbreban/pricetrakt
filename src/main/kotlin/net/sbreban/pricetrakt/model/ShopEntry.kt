package net.sbreban.pricetrakt.model

import javax.persistence.*

@Entity
@Table(name = "shop_entries")
data class ShopEntry(

    @Id
    val id: Int = 0,

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shop_id")
    val shop: Shop = Shop(),

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    val product: Product = Product(),

    val url: String = ""
)