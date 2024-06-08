import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class DatafromWebsiteToExcel {

	public static WebDriver _driver;

	public static void main(String[] args) throws IOException {

		base _base = new base(_driver);
		_driver = _base.intializeDriver();

		String path = ".\\testdata\\population.xlsx";
		
		
		XLUtility xlutil = new XLUtility(path);
		xlutil.setCellData("sheet1", 0,0, "COUNTRY");
		xlutil.setCellData("sheet1", 0,1, "POPULATION");
		xlutil.setCellData("sheet1", 0,2, "%OF WORLD");
		xlutil.setCellData("sheet1", 0,3, "DATE");
		xlutil.setCellData("sheet1", 0,4, "SOURCE");

		// cAPTURE TABLE ROWS

		
		WebElement table = _driver.findElement(By.xpath("(//tbody)[1]"));

		int rows = table.findElements(By.xpath("//tr")).size();
			System.out.println(rows);
		for (int i = 1; i < rows; i++) 
		{
			String country = table.findElement(By.xpath("//tr[" + i + "]//td[1]")).getText();
			String population = table.findElement(By.xpath("//tr[" + i + "]//td[2]")).getText();
			String perOf_world = table.findElement(By.xpath("//tr[" + i + "]//td[3]")).getText();
			String date = table.findElement(By.xpath("//tr[" + i + "]//td[4]")).getText();
			String source = table.findElement(By.xpath("//tr[" + i + "]//td[5]")).getText();
			
			System.out.println(country + population + perOf_world + date + source);
			
			// writing data into the excel
			
			xlutil.setCellData("sheet1", i, 0, country);
			xlutil.setCellData("sheet1", i, 1, population);
			xlutil.setCellData("sheet1", i, 2, perOf_world);
			xlutil.setCellData("sheet1", i, 3, date);
			xlutil.setCellData("sheet1", i, 4, source);
			
		}
		System.out.println("succesflly  enterd into excel");
		_driver.quit();
	}

}
