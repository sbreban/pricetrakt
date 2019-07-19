package net.sbreban.pricetrakt

import net.sbreban.pricetrakt.scrapper.ScrapperRunner
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledScrapping(private val scrapperRunner: ScrapperRunner) {

  @Scheduled(fixedDelay = 30 * 60 * 1000)
  fun scrap() {
    scrapperRunner.run()
    val now = System.currentTimeMillis() / 1000
    println("Scrapping run for all products at $now")
  }
}