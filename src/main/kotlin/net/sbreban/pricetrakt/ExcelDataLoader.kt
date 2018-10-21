package net.sbreban.pricetrakt

import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Component
import java.io.File
import java.io.FileInputStream

@Component
class ExcelDataLoader {
  fun extractExcelFile() {
    val excelFileName = "LongTermShopping.xlsx"
    val excelFile = FileInputStream(File(excelFileName))
    val workbook = XSSFWorkbook(excelFile)

    val sheet = workbook.getSheet("Hardware")
    val rows = sheet.iterator()
    while (rows.hasNext()) {
      val currentRow = rows.next()
      if (currentRow.physicalNumberOfCells > 0) {
        val productCell = currentRow.getCell(0)
        val urlCell = currentRow.getCell(2)
        println("${currentRow.physicalNumberOfCells} $productCell $urlCell")
      }
    }

    workbook.close()
    excelFile.close()
  }
}