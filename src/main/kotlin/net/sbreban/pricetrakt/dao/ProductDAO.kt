package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductDAO : JpaRepository<Product, Int>