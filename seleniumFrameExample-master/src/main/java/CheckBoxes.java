import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CheckBoxes {

	public static void main(String[] arge) {

		// The below code is for disabling the chrome options

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		 // options.addArguments("--disable-notifications");
		  //options.addArguments("--disable-popup-blocking"); 
		WebDriver _driver = new ChromeDriver(options);

		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// WebDriver _driver = new ChromeDriver();
		_driver.get("https://www.ironspider.ca/forms/checkradio.htm");

		for (int i = 1; i < 7; i++) {
			_driver.findElement(By.xpath("//input[@type='checkbox'][" + i + "]")).click();

		}

		_driver.close();

	}

}
