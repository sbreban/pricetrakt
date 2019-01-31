package net.sbreban.pricetrakt.model

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "price_history")
data class PriceHistory (

  @Id
  val id: Int = 0,

  val price: Double = 0.0,

  val currency: String = "",

  val captureTime: Timestamp = Timestamp(System.currentTimeMillis()),

  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "shop_entry_id")
  val shopEntry: ShopEntry = ShopEntry()
)