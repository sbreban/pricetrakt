package net.sbreban.pricetrakt

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.scheduling.annotation.EnableScheduling


@SpringBootApplication
@EnableScheduling
class PricetraktApplication

fun main(args: Array<String>) {
  println("Starting application...")
  SpringApplication.run(PricetraktApplication::class.java, *args)
}
