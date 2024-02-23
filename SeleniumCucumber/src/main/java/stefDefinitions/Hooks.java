package stefDefinitions;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import utilities.WebDriverManager;
import utilities.CustomAssertions;
import utilities.MyUtilities;


public class Hooks extends MyUtilities {

		@Before
		public void beforeScenario() {
		//	specify if any methods
		}
	
		@After(order = 1)
		public void afterScenario(Scenario scenario) {
		if (scenario.isFailed()) {

			System.out.println("Failed scenario");

			try {				
				logger.addScreenCaptureFromBase64String(getbase64Screenshot());
				
			} catch (Exception e) {
				ERROR_MSG = e.toString();
				CustomAssertions.setExceptionMessage(ERROR_MSG, elementName, logger);
			}
		} else {
			System.out.println("Passed scenario");
		}
	}

	@After(order = 0)
	public void quitBrowser() {
		WebDriverManager.closeDriver(driver);
	}

	@After
	public void tearDown() {
		System.out.println("End..");
		extent.flush(); 
	}




}
