import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.formula.ThreeDEval;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class amazonPage {

	WebDriver _driver;
	String data;

	// this is the constructor which is calling
	public amazonPage(WebDriver drv) {
		this._driver = drv;
	}

	// <<<<<<<<<<<<-------THIS METHOD IS FOR ENTERING DATA INTO THE SEARCH AND CLICK
	// ON SEARCH-------->>>>>

	public List<WebElement> searchItems(String text) {
		// search mobile under 10000 in amazon
		_driver.findElement(By.id("twotabsearchtextbox")).clear();
		_driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
		// Click on search button
		_driver.findElement(By.id("nav-search-submit-button")).click();
		// collect alls the items from search results
		List<WebElement> listofproducts = _driver.findElements(By.xpath("//div[@data-cy='title-recipe']//h2"));
		return listofproducts;
	}

	// <<<<-------------this method is for printing the text ---------->>>>>>>>

	public void printAllItems(List<WebElement> items) {
		for (int i = 0; i < items.size(); i++) {
			System.out.println(items.get(i).getText() + "----->" + items.get(i).getText());
		}
	}
	// <<<<<--------------------------------------------------------------------------------------------------------------------------->>>>>//

	public void Top20SearchListToExcel(List<WebElement> items) throws IOException {

		String path = ".\\testdata\\mobile1.xlsx";
		int rows = _driver.findElements(By.xpath("//div[@data-cy='title-recipe']//h2")).size();
		System.out.println(rows);
		for (int r = 1; r <= -rows; r++) {
			String top20list = _driver
					.findElement(By.xpath(
							"(//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2'])[" + r + "]"))
					.getText();
			// writing data into the excel
			XLUtility xlutil = new XLUtility(path);
			xlutil.setCellData("sheet1", r, 0, top20list);
		}
		System.out.println("file is sucessfuly created ");
	}

	public void SearchtheselectedProdct(String text) {
		_driver.findElement(By.id("twotabsearchtextbox")).clear();
		_driver.findElement(By.id("twotabsearchtextbox")).sendKeys(text);
		_driver.findElement(By.id("nav-search-submit-button")).click();

		// _driver.findElement(By.xpath("(//a[@class='a-link-normal s-underline-text
		// s-underline-link-text s-link-style a-text-normal'])[1]")).click();

		String originalWindow = _driver.getWindowHandle();
		System.out.println("the value of original window handle : " + originalWindow);
		assert _driver.getWindowHandles().size() == 1;

		_driver.findElement(By.linkText(
				"Samsung 183 L, 4 Star, Digital Inverter, Direct-Cool Single Door Refrigerator (RR20C1724CU/HL, Camellia Blue, 2024 Model)"))
				.click();
		for (String windowHandle : _driver.getWindowHandles()) {

			if (!originalWindow.contentEquals(windowHandle)) {
				_driver.switchTo().window(windowHandle);
				break;
			}
		}
	}

	public void addtocart() {
		_driver.findElement(By.id("buy-now-button")).click();
	}

	public void singleCheckBoxCheckAndUncheck(WebElement id,WebElement css,WebElement xpath) {
		
		_driver.findElement(By.id("")).click();
		
		
		
	}
	public void addtocartANDlogin() {
		_driver.findElement(By.id("buy-now-button")).click();
		_driver.findElement(By.id("ap_email")).sendKeys("9014788727");
		_driver.findElement(By.id("continue")).click();
		_driver.findElement(By.id("ap_password")).sendKeys("123456789");
		_driver.findElement(By.id("signInSubmit")).click();
		String text=_driver.findElement(By.xpath("(//span[@class='a-button-text a-text-center'])")).getText();
		System.out.println(text);
		_driver.findElement(By.id("a-autoid-2-announce")).click();

		
		//clicking on check boxes to select the UPI payment 
	_driver.findElement(By.xpath("(//input[@type='radio'])[3]")).click();
	_driver.findElement(By.id("pp-0fLKQR-111")).sendKeys("123456789@ybl");
		
_driver.quit();
	}
}
