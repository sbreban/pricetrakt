package net.sbreban.pricetrakt

import net.sbreban.pricetrakt.dao.ProductDAO
import net.sbreban.pricetrakt.dao.ShopDAO
import net.sbreban.pricetrakt.dao.ShopEntryDAO
import net.sbreban.pricetrakt.model.Product
import net.sbreban.pricetrakt.model.Shop
import net.sbreban.pricetrakt.model.ShopEntry
import org.apache.poi.ss.usermodel.Cell
import org.apache.poi.ss.usermodel.CellType
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.core.io.ClassPathResource
import org.springframework.stereotype.Component

@Component
class ExcelDataLoader(val productDAO: ProductDAO, val shopDAO: ShopDAO, val shopEntryDAO: ShopEntryDAO) {
  fun extractExcelFile(fileName: String) {
    val excelFile = ClassPathResource(fileName).inputStream
    val workbook = XSSFWorkbook(excelFile)

    val sheet = workbook.getSheet("Hardware")
    val rows = sheet.iterator()
    var product: Product? = null
    rows.next()
    while (rows.hasNext()) {
      val currentRow = rows.next()
      if (currentRow.physicalNumberOfCells > 0) {
        val productCell = currentRow.getCell(0)
        if (cellNotBlank(productCell)) {
          val productName = productCell.stringCellValue
          product = getOrInsertProduct(productName)
        }
        val shopCell = currentRow.getCell(1)
        val urlCell = currentRow.getCell(2)
        if (cellNotBlank(shopCell) && cellNotBlank(urlCell) && product != null && product.id != 0) {
          val shopName = shopCell.stringCellValue
          val shop = findOrInsertShop(shopName)
          val url = urlCell.stringCellValue
          findOrInsertShopEntry(url, shop, product)
        }
      }
    }

    workbook.close()
    excelFile.close()
  }

  private fun findOrInsertShopEntry(url: String, shop: Shop?, product: Product) {
    var shopEntry = shopEntryDAO.findByUrl(url)
    if (shopEntry == null) {
      shopEntry = ShopEntry(shop = shop!!, url = url)
      product.addShopEntry(shopEntry)
      shopEntryDAO.saveAndFlush(shopEntry)
      println("Inserted shop entry for product: ${product.name}, url: ${shopEntry.url}")
    }
  }

  private fun findOrInsertShop(shopName: String): Shop? {
    var shop = shopDAO.findByName(shopName)
    if (shop == null) {
      shop = Shop(name = shopName)
      shop = shopDAO.saveAndFlush(shop)
      println("Inserted shop with name: $shopName, id: ${shop.id}")
    }
    return shop
  }

  private fun getOrInsertProduct(productName: String): Product? {
    var product: Product? = productDAO.findByName(productName)
    if (product == null) {
      product = Product(name = productName)
      product = productDAO.saveAndFlush(product)
      println("Inserted product with name: $productName, id: ${product.id}")
    }
    return product
  }

  private fun cellNotBlank(cell: Cell?) = cell != null && cell.cellType != CellType.BLANK
}