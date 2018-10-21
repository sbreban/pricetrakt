package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Shop
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ShopDAO : JpaRepository<Shop, Int> {
  @Query("SELECT s FROM Shop s WHERE s.name = :name")
  fun findByName(@Param("name") name: String): Shop?
}