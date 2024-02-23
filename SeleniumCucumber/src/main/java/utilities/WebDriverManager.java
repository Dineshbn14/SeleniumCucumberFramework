package utilities;

import org.openqa.selenium.WebDriver;

public class WebDriverManager {

	
	

	public static void closeDriver(WebDriver driver) {
		driver.quit();
	}
}
