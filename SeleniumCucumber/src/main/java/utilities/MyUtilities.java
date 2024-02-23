package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Base64;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class MyUtilities {
	
public static WebDriver driver;	
public static ExtentTest logger;
public static String ERROR_MSG;	
public static String elementName;	
public static ExtentReports extent = new ExtentReports();
public static ConfigurationProperties configProperties = new ConfigurationProperties();

	/*--------------Navigatue to required URL-------------------*/

	public static String navigateToURL() {
		String url = configProperties.getURL();
		String browser = configProperties.getBrowser();
		try {
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("URL : "+url);
			driver.get(url);
			if (browser.equalsIgnoreCase("ie")) {
				driver.findElement(By.linkText("More information")).click();

				driver.findElement(By.linkText("Go on to the webpage (not recommended)")).click();
				waitForElementPresentByXpath("//span[contains(text(),'Login')]");
			}
			logger.info("Application URL " + url + " launched successfully");
			return "false";
		} catch (Exception e) {
			ERROR_MSG = e.toString();
		}
		return url;
	}
	
	
	public static WebDriver launchDriver() {
		WebDriver getDriver = null;
		String browser = configProperties.getBrowser();
		try {
			if (browser.equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
				logger.info("Able to launch Firefox browser");
				getDriver = driver;

			} else if (browser.equalsIgnoreCase("chrome") ) {
				ChromeOptions options = new ChromeOptions();

				options.addArguments("--remote-allow-origins=*");
				driver = new ChromeDriver(options);
				
				//driver.manage().deleteAllCookies();
			//	logger.info("Able to launch Google "+browser+" browser");
				getDriver = driver;
			} 
			else if (browser.equalsIgnoreCase("edge")) {
				driver = new EdgeDriver();
				System.out.println("Able to launch Edge browser");
				logger.info("Able to launch Edge browser");
				getDriver = driver;
			} else {
				getDriver = driver;
			}

		} catch (Exception e) {
			ERROR_MSG = e.toString();
		} 
		return getDriver;
	}

	public static boolean waitForElementPresentByXpath(String xpath) {
		Boolean result = false;
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		return result;
	}

	public boolean waitForElementNotPresentByXpath(String xpath) {
		Boolean result = false;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
			result = true;
			elementName = xpath;
		} catch (Exception e) {
			ERROR_MSG = e.toString();
		}
		return result;
	}
	
	public static String getbase64Screenshot() {
		String img = "";
		elementName = "screenshot";
		File source, destination = null;
		String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			source = ts.getScreenshotAs(OutputType.FILE);
			destination = new File(System.getProperty("user.dir") + "/target/screenshots/" + timestamp + ".png");
			FileUtils.copyFile(source, destination);
			byte[] byteimg = IOUtils.toByteArray(new FileInputStream(destination));
			img = Base64.getEncoder().encodeToString(byteimg);
		} catch (Exception e) {
			ERROR_MSG = e.toString();
			logger.fail(ERROR_MSG);
			CustomAssertions.setExceptionMessage(ERROR_MSG, elementName, logger);
		}
		return img;
	}

}

