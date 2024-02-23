package stefDefinitions;

import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import utilities.ConfigurationProperties;
import utilities.MyUtilities;


public class LoginPageStepDef {
	
	//launches the driver and returns driver object
	WebDriver driver = MyUtilities.launchDriver();
	
	//same driver is passing to respective pages
	private LoginPage login = new LoginPage(driver);
	
	ConfigurationProperties configs = new ConfigurationProperties();
	
	@Given("user is able to navigate to url")
	public void user_is_able_to_navigate_to_url() {
		MyUtilities.navigateToURL();
	}

	@When("user logs in as {string} and {string}")
	public void user_logs_in(String userId, String passwordFile) {
		String pwd = configs.getUserCreds(userId, passwordFile);
		login.loginToSwagLabs(userId,pwd);
	}

	@Then("user navigates to the dashboard and verifies title")
	public void user_navigates_to_dashboard_and_verifies_title() {
		login.navigateToDahboard();
		
	}

}
