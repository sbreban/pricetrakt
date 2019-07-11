package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Price
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PriceDAO : JpaRepository<Price, Int>