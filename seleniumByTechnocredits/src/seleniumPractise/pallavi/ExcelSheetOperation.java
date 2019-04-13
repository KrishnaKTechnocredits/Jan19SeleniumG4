package seleniumPractise.pallavi;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetOperation {
	Workbook workbook = null;

	public ExcelSheetOperation(String filePath) throws IOException {
		File file = new File(filePath);

		FileInputStream input = new FileInputStream(file);

		workbook = new XSSFWorkbook(input);

	}

	public Object[][] getAllRows(String sheetName) {
		Sheet sheet = workbook.getSheet(sheetName);

		int totalRows = workbook.getSheet(sheetName).getLastRowNum();

		int totalCols = workbook.getSheet(sheetName).getRow(0).getLastCellNum();

		Object[][] data = new Object[totalRows][totalCols];

		for (int rowIndex = 1; rowIndex <= totalRows; rowIndex++) {
			for (int colIndex = 0; colIndex < totalCols; colIndex++) {
				Cell cell = sheet.getRow(rowIndex).getCell(colIndex);
				if (cell == null) {
					data[rowIndex - 1][colIndex] = "";

				} else if (CellType.NUMERIC == cell.getCellType()) {
					data[rowIndex - 1][colIndex] = cell.getNumericCellValue();
				} else if (CellType.STRING == cell.getCellType()) {
					try {
						data[rowIndex - 1][colIndex] = cell.getStringCellValue();
					} catch (Exception e) {
						e.printStackTrace();
					}
				} else if (CellType.BOOLEAN == cell.getCellType()) {
					data[rowIndex - 1][colIndex] = cell.getBooleanCellValue();
				}
			}
		}

		return data;
	}

}
