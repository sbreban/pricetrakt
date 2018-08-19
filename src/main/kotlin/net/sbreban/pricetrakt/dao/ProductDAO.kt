package net.sbreban.pricetrakt.dao

import net.sbreban.pricetrakt.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ProductDAO : JpaRepository<Product, Int> {

  @Query("SELECT p FROM Product p WHERE p.name = :name")
  fun findByName(@Param("name") name: String): Product
}