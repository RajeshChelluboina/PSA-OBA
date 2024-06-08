import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class base {

	WebDriver _driver;

	// this is the constructor which is calling
	public base(WebDriver drv) {
		this._driver = drv;
	}

	public WebDriver intializeDriver() {

		// Initialize Chrome driver
		ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--bwsi");
       ops.addArguments("--disable-infobars");
        ops.addArguments("--disable-notifications");

        _driver = new ChromeDriver(ops);
		
	

		// appliend wait conditon with imlicitywait
		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Launch Amazon application
		_driver.get("https://www.amazon.in/");

		// _driver.get("https://en.wikipedia.org/wiki/List_of_countries_and_dependencies_by_population");

		// maximize driver
		_driver.manage().window().maximize();
		
	

		return _driver;
	}
}
