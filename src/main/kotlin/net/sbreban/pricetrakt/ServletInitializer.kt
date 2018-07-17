package net.sbreban.pricetrakt

import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

  override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
    return application.sources(PricetraktApplication::class.java)
  }

}