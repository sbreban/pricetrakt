package net.sbreban.pricetrakt.model

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "shops")
data class Shop(
    @Id
    val id: Int = 0,

    val name: String = ""
)