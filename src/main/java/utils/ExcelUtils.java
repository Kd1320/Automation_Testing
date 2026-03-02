
package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelUtils {

    // Write under project target so Jenkins/workspace stays clean
    private static final String filePath =
            "target/CustomerData.xlsx";

    public static void writeCustomerData(String name, String email,
                                         String mobile, String custId, String status) {

        File file = new File(filePath);
        file.getParentFile().mkdirs();

        Workbook workbook;
        Sheet sheet;

        try {
            if (file.exists()) {
                try (FileInputStream fis = new FileInputStream(file)) {
                    workbook = new XSSFWorkbook(fis);
                }
                sheet = workbook.getSheet("Customers");
                if (sheet == null) {
                    sheet = workbook.createSheet("Customers");
                }
            } else {
                workbook = new XSSFWorkbook();
                sheet = workbook.createSheet("Customers");

                // Header row
                Row header = sheet.createRow(0);
                header.createCell(0).setCellValue("Name");
                header.createCell(1).setCellValue("Email");
                header.createCell(2).setCellValue("Mobile");
                header.createCell(3).setCellValue("CustomerID");
                header.createCell(4).setCellValue("Status");
            }

            int lastRow = sheet.getLastRowNum() + 1;
            // If the sheet is empty (no rows), lastRow may be 0 but we want row 1
            if (sheet.getRow(0) == null || sheet.getPhysicalNumberOfRows() == 0) {
                lastRow = 1;
            } else {
                lastRow = sheet.getLastRowNum() + 1;
            }

            Row row = sheet.createRow(lastRow);
            row.createCell(0).setCellValue(name);
            row.createCell(1).setCellValue(email);
            row.createCell(2).setCellValue(mobile);
            row.createCell(3).setCellValue(custId);
            row.createCell(4).setCellValue(status);

            try (FileOutputStream fos = new FileOutputStream(filePath)) {
                workbook.write(fos);
            }
            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
