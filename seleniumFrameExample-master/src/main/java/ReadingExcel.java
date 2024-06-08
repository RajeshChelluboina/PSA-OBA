import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

	public static void main(String[] args) throws IOException {

		// assigning file to file path to variable that will help to pass as an argument
		String excelFilePath = ".\\testdata\\testfile.xlsx";

		// opening file using file input stream
		FileInputStream inputstream = new FileInputStream(excelFilePath);

		XSSFWorkbook workbook = new XSSFWorkbook(inputstream);

		// work book get sheet is used to get the sheet we needed and we need to give
		// the name of the sheet
		workbook.getSheet("Sheet1");

		// the sheet we got is reffering to the sheet

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// using for loop we are extracting the data

		int rows = sheet.getLastRowNum();
		int colums = sheet.getRow(1).getLastCellNum();

		/// <<<<---------------------------------- METHOD ONE--------------------------------------------------->>>>>>>>>>
		/*
		 * for (int r= 0;r<=rows;r++) {
		 * 
		 * XSSFRow row = sheet.getRow(r); for (int c=0 ; c<colums;c++) { XSSFCell cell =
		 * row.getCell(c);
		 * 
		 * switch (cell.getCellType()) { case STRING :
		 * System.out.print(cell.getStringCellValue()); break; case NUMERIC:
		 * System.out.print(cell.getNumericCellValue());break; case BOOLEAN :
		 * System.out.print(cell.getBooleanCellValue());break;
		 * 
		 * }
		 * 
		 * System.out.print("|");
		 * 
		 * }
		 * 
		 * System.out.println(); }
		 */
		//// <<<<<<----------------------------------METHOD TWO-------------------------------------------------------->>>>>
		Iterator iterator = sheet.iterator();

		while (iterator.hasNext()) {
			XSSFRow row = (XSSFRow) iterator.next();

			Iterator celliterator = row.cellIterator();

			while (celliterator.hasNext()) {

				XSSFCell cell = (XSSFCell) celliterator.next();

				switch (cell.getCellType()) {
				case STRING:
					System.out.print(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.print(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.print(cell.getBooleanCellValue());
					break;

				}

				System.out.print("|");
			}

		}

	}
}
