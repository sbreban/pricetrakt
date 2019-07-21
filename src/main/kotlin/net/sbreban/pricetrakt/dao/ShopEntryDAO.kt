package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.ShopEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Component

@Component
interface ShopEntryDAO : JpaRepository<ShopEntry, Int> {
  @Query("SELECT entry FROM ShopEntry entry WHERE entry.url = :url")
  fun findByUrl(@Param("url") url: String): ShopEntry?
}