import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	public FileInputStream filein;
	public FileOutputStream fileout;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;

	String path;

	XLUtility(String path) {

		this.path = path;

	}

	public int getRowCount(String sheetName) throws IOException {
		filein = new FileInputStream(path);
		workbook = new XSSFWorkbook(filein);
		sheet = workbook.getSheet(sheetName);
		int rowcount = sheet.getLastRowNum();
		workbook.close();
		filein.close();
		return rowcount;
	}

	public int getCellCount(String sheetName, int rownum) throws IOException {
		filein = new FileInputStream(path);
		workbook = new XSSFWorkbook(filein);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		filein.close();
		return cellcount;
	}

	public String getCellData(String sheetName, int rownum, int cellnum) throws IOException {

		filein = new FileInputStream(path);
		workbook = new XSSFWorkbook(filein);
		sheet = workbook.getSheet(sheetName);
//		if (sheet == null) {
//			sheet = workbook.createSheet(sheetName);
//		}
		 row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String celldata=cell.getStringCellValue();
		return celldata;
	}

	public void setCellData(String sheet1, int rownum, int colnum, String data) throws IOException {
		FileInputStream filein = null;
		FileOutputStream fileout = null;
		try {
			// Check if the file exists, if not, create a new workbook
			File exlfile = new File(path);
			if (!exlfile.exists()) {
				workbook = new XSSFWorkbook();
			} else {
				filein = new FileInputStream(path);
				workbook = new XSSFWorkbook(filein);
			}

			// Get or create the sheet
			sheet = workbook.getSheet(sheet1);
			if (sheet == null) {
				sheet = workbook.createSheet(sheet1);
			}

			// Get or create the row
			row = sheet.getRow(rownum);
			if (row == null) {
				row = sheet.createRow(rownum);
			}

			// Set the cell value
			cell = row.createCell(colnum);
			cell.setCellValue(data);

			// Write changes to the file
			fileout = new FileOutputStream(path);
			workbook.write(fileout);
			fileout.close();
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
