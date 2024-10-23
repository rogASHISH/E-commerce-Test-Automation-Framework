package com.Ecommerce.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	public static List<String[]> readExcel(String filePath, String sheetName) {
		List<String[]> data = new ArrayList<>();
		try (FileInputStream fis = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

			Sheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();

			for (int i = 1; i < rowCount; i++) { // Skipping header row
				Row row = sheet.getRow(i);
				String[] rowData = new String[row.getPhysicalNumberOfCells()];
				for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
					rowData[j] = row.getCell(j).toString();
				}
				data.add(rowData);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
}
