package net.sbreban.pricetrakt

import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import java.io.File
import java.io.FileInputStream

@SpringBootApplication
class PricetraktApplication

fun main(args: Array<String>) {
  println("Starting application...")
  extractExcelFile()
  SpringApplication.run(PricetraktApplication::class.java, *args)
}

private fun extractExcelFile() {
  val excelFileName = "LongTermShopping.xlsx"
  val excelFile = FileInputStream(File(excelFileName))
  val workbook = XSSFWorkbook(excelFile)

  val sheet = workbook.getSheet("Hardware")
  val rows = sheet.iterator()
  while (rows.hasNext()) {
    val currentRow = rows.next()
    val cellsInRow = currentRow.iterator()
    while (cellsInRow.hasNext()) {
      val currentCell = cellsInRow.next()
      if (currentCell.cellType === CellType.STRING) {
        print(currentCell.stringCellValue + " | ")
      } else if (currentCell.cellType === CellType.NUMERIC) {
        print(currentCell.numericCellValue.toString() + " | ")
      }
    }
    println()
  }

  workbook.close()
  excelFile.close()
}
