import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Duration;
import java.util.List;

import org.apache.poi.EmptyFileException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainScript {

	public static WebDriver _driver;

	public static void main(String[] arg) throws IOException, InterruptedException {
		
		
		// <<<<<<--creating an object so that we can accesss all
		// the methods from the base class----->>>>>>
		base _base = new base(_driver);
		_driver = _base.intializeDriver();

		// <<<<<<--creating an object so that we can accesss all
		// the methods from the amazonPage class----->>>>>>
		amazonPage _amz = new amazonPage(_driver);
		// Find mobiles under 10000
		List<WebElement> mobiles = _amz.searchItems("Laptop under 60000");
		_amz.printAllItems(mobiles);
		_amz.Top20SearchListToExcel(mobiles);

		// Gtting cell value from excel

		
		  String path = ".\\testdata\\mobile.xlsx"; 
		  XLUtility xutil = new XLUtility(path);
		  
		  String inputdatatopurchase = xutil.getCellData("sheet1", 6, 0);
		  _amz.SearchtheselectedProdct(inputdatatopurchase);
		  
		  //WebElement cartellemnt= _driver.findElement(By.id("add-to-cart-button"));
		  _amz.addtocartANDlogin();

	}
}
