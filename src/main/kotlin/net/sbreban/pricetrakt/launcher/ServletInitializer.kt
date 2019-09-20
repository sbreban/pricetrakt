package net.sbreban.pricetrakt.launcher

import net.sbreban.pricetrakt.PricetraktApplication
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer

class ServletInitializer : SpringBootServletInitializer() {

  override fun configure(application: SpringApplicationBuilder): SpringApplicationBuilder {
    return application.sources(PricetraktApplication::class.java)
  }

}