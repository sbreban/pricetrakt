package net.sbreban.pricetrakt.schedule

import net.sbreban.pricetrakt.scrapper.ScrapperRunner
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class ScheduledScrapping(private val scrapperRunner: ScrapperRunner) {

  @Scheduled(fixedDelay = 60 * 60 * 1000, initialDelay = 60 * 60 * 1000)
  fun scrap() {
    scrapperRunner.run()
    val now = System.currentTimeMillis() / 1000
    println("Scrapping run for all products at $now")
  }
}