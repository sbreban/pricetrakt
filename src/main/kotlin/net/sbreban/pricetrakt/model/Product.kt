package net.sbreban.pricetrakt.model

import javax.persistence.*
import javax.persistence.FetchType



@Entity
@Table(name = "products")
data class Product(
    @Id
    val id: Int = 0,

    val name: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "product")
    val shopEntries: List<ShopEntry> = mutableListOf()
)