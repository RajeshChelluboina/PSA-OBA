import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AlertsAndPopups {
	WebDriver _driver;

	
	
	
	public void alartsManagement() {
	
		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		WebDriver _driver = new ChromeDriver(options);

		_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		

		

		
		_driver.get("https://demo.automationtesting.in/Alerts.html");
		_driver.findElement(By.cssSelector("button.btn-danger")).click();
		Alert myalert =_driver.switchTo().alert();
		myalert.accept();
		_driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
		_driver.findElement(By.cssSelector("button.btn-primary")).click();
		myalert.dismiss();
		_driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
		_driver.findElement(By.cssSelector("button.btn-info")).click();
	
		myalert.sendKeys("'NARESH'");
		myalert.accept();

	}

	

	public static void main(String[] args) {
		
		AlertsAndPopups aANDp = new  AlertsAndPopups();
		
		
		aANDp.alartsManagement();

	
		
		

	}

}
