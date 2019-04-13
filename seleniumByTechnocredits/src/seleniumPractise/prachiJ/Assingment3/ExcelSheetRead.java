package seleniumPractise.prachiJ.Assingment3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetRead {
	Workbook workbook = null;

	ExcelSheetRead(String path) throws IOException {
		File file = new File(path);
		FileInputStream input = new FileInputStream(file);
		workbook = new XSSFWorkbook(input);
	}

	Object[][] getRowData(String sheetName) throws IOException {
		int FirstRow = workbook.getSheet(sheetName).getFirstRowNum();
		int FirstCol = workbook.getSheet(sheetName).getRow(0).getFirstCellNum();
		int rows = workbook.getSheet(sheetName).getLastRowNum(); 																												
		int cols = workbook.getSheet(sheetName).getRow(0).getLastCellNum(); 
		Object[][] cellData = new String[rows][cols]; 
														
		boolean isHeader = true;
		if (isHeader) {
			FirstRow++;
		}
		for (int i = FirstRow; i <= rows; i++) {
			for (int j = FirstCol; j < cols; j++) {
				if (CellType.NUMERIC == workbook.getSheet(sheetName).getRow(i).getCell(j).getCellType()) {
					cellData[i - 1][j] = workbook.getSheet(sheetName).getRow(i).getCell(j).getNumericCellValue();
				} else if (CellType.STRING == workbook.getSheet(sheetName).getRow(i).getCell(j).getCellType()) {
					cellData[i - 1][j] = workbook.getSheet(sheetName).getRow(i).getCell(j).getStringCellValue().trim();
				} else if (CellType.BLANK == workbook.getSheet(sheetName).getRow(i).getCell(j).getCellType()) {
					cellData[i - 1][j] = "";
				}
			}
		}
		return cellData;
	}
}
