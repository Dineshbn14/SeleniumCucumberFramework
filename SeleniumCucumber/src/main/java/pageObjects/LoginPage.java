package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;
	
	// constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Login into SwagLabs
	public void loginToSwagLabs(String userId, String pwd) {

	try {
		driver.findElement(By.id("user-name")).sendKeys(userId);
		
		driver.findElement(By.id("password")).sendKeys(pwd);
		
		driver.findElement(By.id("login-button")).click();	
		
		String title = driver.getTitle();
		System.out.println("Title is: "+ title);
			
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	}

	//Navigate Dash board
	public void navigateToDahboard() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	

}
