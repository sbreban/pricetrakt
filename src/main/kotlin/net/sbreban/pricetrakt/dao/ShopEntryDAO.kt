package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.ShopEntry
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Component

@Component
interface ShopEntryDAO: JpaRepository<ShopEntry, Int>