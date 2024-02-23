package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestJavaMethods {
	
	
	static WebDriver driver;
	
	public static void login() {
		
		try {
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--remote-allow-origins=*");
		
			String url = "https://www.saucedemo.com";
			
			driver = new ChromeDriver(options);
			
			driver.manage().window().maximize();
			
			driver.manage().deleteAllCookies();
			
			driver.get(url);
			
			driver.findElement(By.id("user-name")).sendKeys("standard_user");
			
			driver.findElement(By.id("password")).sendKeys("secret_sauce");
			
			driver.findElement(By.id("login-button")).click();	
			
			String title = driver.getTitle();
			System.out.println("Title is: "+ title);
			
			driver.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}


	public static void main(String[] args) {

		login();  

	}

}
