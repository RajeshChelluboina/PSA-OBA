 import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromFormulaCell {

	public static void main(String[] args) throws IOException {

		String path = ".\\testdata\\mobile.xlsx";

		FileInputStream file = new FileInputStream(path);

		XSSFWorkbook workbook = new XSSFWorkbook(file);

		XSSFSheet sheet = workbook.getSheet("sheet1");

		int rows = sheet.getLastRowNum();
		int colm = sheet.getRow(1).getLastCellNum();

		for (int r = 0; r <= rows; r++) {

			XSSFRow row = sheet.getRow(r);

			for (int c = 0; c < colm; c++) {

				XSSFCell cell = row.getCell(c);

				switch (cell.getCellType()) 
				{
				case STRING:
					System.out.print(cell.getStringCellValue());break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;

				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;
				case FORMULA:
					System.out.println(cell.getNumericCellValue());
					break;
				}
				System.out.print("|");

			}
			System.out.println();
		}

		file.close();
		workbook.close();

	}

}
