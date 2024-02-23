package testRunner;

import org.testng.annotations.DataProvider;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

	@CucumberOptions(
		    features = "src/test/resources/Features",
		    glue = {"stefDefinitions"},
		    plugin = {"pretty", "html:target/cucumber-reports"},
		    tags = "@LoginPage"
		)

	public class MyTestRunner extends AbstractTestNGCucumberTests {

		@Override
		@DataProvider(parallel = false)
		public Object[][] scenarios() {
			return super.scenarios();
		}
	}


