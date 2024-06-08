import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcelDemo1 {

	public static void main(String[] args) throws IOException {
//creating a work book 
		XSSFWorkbook workbook = new XSSFWorkbook();

		XSSFSheet sheet = workbook.createSheet("sheet Name ");

//		Object empdata[][] = { { "Emp ID", "Name", "Job" }, { "101", "David", "Enginner" },
//				{ "102", "smait", "manager" }, { "103", "sedhu", "analyst" } };

//<<<<<------------------------------------------------Method 1 ----------------------------------->>>>>>

	/*   // Using for loop

		// finding the length of the rows and colums
		int rows = empdata.length;
		int cols = empdata[0].length;
		// printing the length of the rows and colums

		System.out.println(rows);
		System.out.println(cols);

		// using for loop for itteration of rows
		for (int r = 0; r < rows; r++) {

			// creating the rows in the sheet
			XSSFRow row = sheet.createRow(r);

			// using for loop for itteration of colums
			for (int c = 0; c < cols; c++) {
				// creating the cell in rows
				XSSFCell cell = row.createCell(c);

				Object value = empdata[r][c];

				// using an if condition for assing the "Type " of the variable
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean)value);

			}
		}
*/
		
		
		//<<<<<<----------------------------------------Method 2 -------------------------------->>>>>>>	
		
		
	/*	//creating the variable and assigning some value due to the reason this may give the null value exception 
		int rowCount = 0;
		
		// enhaced for loop is used to itterate and entering the data into the excel sheet 
		for (Object emp[] : empdata)

		{
			
			//creating the row  in the sheet and incrementing using the ++ and assing the value to a variable 
			XSSFRow row = sheet.createRow(rowCount++);

			int columncount = 0;

			for (Object value : emp) {
				XSSFCell cell = row.createCell(columncount++);
// hear  the value is in Object formate and we need to corvert them using if condition this is also called type casting 
				
				
				//hear in "if " condition 
				if (value instanceof String)
					cell.setCellValue((String) value);
				if (value instanceof Integer)
					cell.setCellValue((Integer) value);
				if (value instanceof Boolean)
					cell.setCellValue((Boolean) value);

			}

		}
		// assing path to a variabl
		String filePath = ".\\testdata\\testfile2.xlsx";

		// creatin an fileoutput for put the file in paticular file path
		FileOutputStream outstream = new FileOutputStream(filePath);

		// wring the data into the paticular file 
		workbook.write(outstream);

		// closing the excel file
		outstream.close(); 
		workbook.close();

		// confirmation message to make sure the data is written in excel file

		System.out.println("Employe data is sussfully written");  
	*/	
		//<<<<<----------------------------------------------Method 3 ------------------------------------>>>>>>>>>>>>>>>
		
		
	ArrayList<Object[]>	 empdata2 =  new ArrayList<Object[]>();
	empdata2.add(new Object[]{"Emp ID", "Name","Job"});
	empdata2.add(new Object[]{"101","David","Enginner"});
	empdata2.add(new Object[]{"102", "smait","manager"});
	empdata2.add(new Object[]{"103", "sedhu","analyst"});
	
		
	
	
	int rownum = 0;
	
	
	for (Object[]emp:empdata2) {
		XSSFRow row = sheet.createRow(rownum++);
		int cellnum =0;
		
		for(Object value :emp) {
			
			XSSFCell cell = row.createCell(cellnum++);
			
			if (value instanceof String)
				cell.setCellValue((String) value);
			if (value instanceof Integer)
				cell.setCellValue((Integer) value);
			if (value instanceof Boolean)
				cell.setCellValue((Boolean) value);

		}
		
	}
		 
	// assing path to a variabl
					String filePath = ".\\testdata\\testfile2.xlsx";

				// creatin an fileoutput for put the file in paticular file path
				FileOutputStream outstream = new FileOutputStream(filePath);
				// closing the excel file
				outstream.close(); 
				workbook.close();

				// confirmation message to make sure the data is written in excel file

				System.out.println("Employe data is sussfully written"); 
				
			
}

}
