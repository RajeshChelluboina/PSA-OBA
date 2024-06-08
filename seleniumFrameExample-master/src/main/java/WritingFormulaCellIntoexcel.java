import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingFormulaCellIntoexcel {

	public static void main(String[] args) throws IOException {

		String path = "C:\\Users\\EX perimental 1\\eclipse-workspace\\TestSelenium\\testdata\\testfile52.xlsx";
		FileInputStream filein = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(filein);
	
		
		
		
		/////<<<<<<<<<-------------------method for entring formula into the excel sheet -------------------------->>>>>>>>>>>>>>>
		
		/*XSSFSheet sheet = workbook.createSheet("nubmersheet");

		XSSFRow row = sheet.createRow(0);

		row.createCell(0).setCellValue(10);
		row.createCell(1).setCellValue(20);
		row.createCell(2).setCellValue(30);

		row.createCell(3).setCellFormula("A1*B1*C1");

		

		workbook.write(file);
		file.close();
		workbook.close();
		System.out.println("work book is created ");
*/
		
		
	/////<<<<<<<<<-------------------method for calucualate existing data  -------------------------->>>>>>>>>>>>>>>
		
	XSSFSheet sheet = workbook.getSheetAt(1);
	
	sheet.getRow(8).getCell(2).setCellFormula("SUM(C2:C8)");
	
	filein.close();
	FileOutputStream fileout = new FileOutputStream(path);
	workbook.write(fileout);
	workbook.close();
	
	fileout.close();
		System.out.println("calculatio is done ");
		
		
		
	}

}
