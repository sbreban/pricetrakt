package net.sbreban.pricetrakt.model

import javax.persistence.*

@Entity
@Table(name = "shops")
data class Shop(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int = 0,

    val name: String = "",

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "shop", orphanRemoval = true)
    val shopEntries: MutableList<ShopEntry> = mutableListOf()
)