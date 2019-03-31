package net.sbreban.pricetrakt

import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationReadyEventListener(private val excelDataLoader: ExcelDataLoader) : ApplicationListener<ApplicationReadyEvent> {

  override fun onApplicationEvent(event: ApplicationReadyEvent) {
    println("onApplicationEvent")
    excelDataLoader.extractExcelFile("classpath:database.xlsx")
  }
}