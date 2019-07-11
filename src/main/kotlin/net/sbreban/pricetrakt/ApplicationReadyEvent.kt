package net.sbreban.pricetrakt

import net.sbreban.pricetrakt.scrapper.ScrapperRunner
import org.springframework.boot.context.event.ApplicationReadyEvent
import org.springframework.context.ApplicationListener
import org.springframework.stereotype.Component

@Component
class ApplicationReadyEventListener(private val excelDataLoader: ExcelDataLoader, private val scrapperRunner: ScrapperRunner) : ApplicationListener<ApplicationReadyEvent> {

  override fun onApplicationEvent(event: ApplicationReadyEvent) {
    println("onApplicationEvent")
    val fileName: String = System.getenv("XLSX_PATH") ?: ""
    excelDataLoader.extractExcelFile(fileName)

    scrapperRunner.run()
  }
}