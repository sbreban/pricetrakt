package net.sbreban.pricetrakt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication


@SpringBootApplication
class PricetraktApplication

fun main(args: Array<String>) {
  println("Starting application...")
  SpringApplication.run(PricetraktApplication::class.java, *args)
}
