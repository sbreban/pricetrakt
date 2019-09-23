package net.sbreban.pricetrakt.graphql.product

import com.coxautodev.graphql.tools.GraphQLResolver
import net.sbreban.pricetrakt.model.Product
import org.springframework.stereotype.Component

@Component
class ProductResolver : GraphQLResolver<Product>