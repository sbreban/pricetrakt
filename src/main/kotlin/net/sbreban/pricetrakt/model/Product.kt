package net.sbreban.pricetrakt.model

import org.hibernate.validator.constraints.NotBlank
import javax.persistence.*

@Entity
@Table(name = "products")
data class Product(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @get: NotBlank
    val name: String = ""
)