package net.sbreban.pricetrakt.graphql.shop

import com.coxautodev.graphql.tools.GraphQLResolver
import net.sbreban.pricetrakt.model.Shop
import org.springframework.stereotype.Component

@Component
class ShopResolver : GraphQLResolver<Shop>