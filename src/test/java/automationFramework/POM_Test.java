/**
 * 
 */
package automationFramework;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import pageObjects.AngularUI;
import automationFramework.AutomationLogic;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * @author clarkald
 *
 */

public class POM_Test {

	//Creating Boolean for Headless Functionality
	static boolean headless = true;
	//Creating ChromeOptions Variable to pass args into Chrome Driver
	static ChromeOptions driverOptions = new ChromeOptions();
	//Setting the Chrome Driver URL
	private static String url = "https://jwatsondev.github.io/ng-prime-testing/";
	//Declaring the Web Driver
	private static WebDriver driver = null;
	//Creating a temp element for testing
	private static WebElement tempElement = null;
	//Setting the Chrome Driver Path
	String chromeDriverPath ="C:\\Users\\clarkald\\Documents\\Development\\chromedriver.exe";
	
	
	@Test
	void removeColumn() {
		//Creating Boolean to hold the result and adding Chrome Args, settings Driver Path, and creating Web Driver
		boolean result =false;
		driverOptions.addArguments(AutomationLogic.getArgs(headless));
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(driverOptions);
		
		driver.manage().timeouts().implicitlyWait(30000, TimeUnit.MILLISECONDS);
		
		//Navigating to the URL defined above
		driver.get(url);
		
		//Clicking the Column drop down and storing the ID Column element then removing the ID Column
		AngularUI.column_Dropdown(driver).click();
		tempElement = AngularUI.ID_Column(driver);
		AngularUI.column_Dropdown_ID_Column(driver).click();
		
		//Storing the result of whether ID Column is on the screen
		result = AutomationLogic.isElementDisplayed(tempElement);
		
		//Failing test if it was found on the UI
		if(result) {
			fail("The column was found on the webpage this wasn't expected");
		}
		
		//Closing the driver
		driver.close();

	}
	
	@Test
	void removeColumnNegative() {
		boolean result = false;
		driverOptions.addArguments(AutomationLogic.getArgs(headless));
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(driverOptions);
		
		driver.get(url);
		
		AngularUI.column_Dropdown(driver).click();
		AngularUI.column_Dropdown_ID_Column(driver).click();
		
		tempElement = AngularUI.Body_Column(driver);
		result = AutomationLogic.isElementDisplayed(tempElement);
		
		if(!result) {
			fail("The body column was not found on the webpage this wasn't expected as the id column was removed.");
		}
		
		driver.close();
	}
	
	@Test 
	void showColumn() {
		
		boolean result = false;
		driverOptions.addArguments(AutomationLogic.getArgs(headless));
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(driverOptions);
		
		driver.get(url);
		
		tempElement = AngularUI.ID_Column(driver);
		result = AutomationLogic.isElementDisplayed(tempElement);
		
		if(!result) {
			fail("The ID Column was not found on the page and it was expected to be there.");
		}
		
		driver.close();
	}
	
	@Test
	void searchColumn() {
		boolean result = false;
		driverOptions.addArguments(AutomationLogic.getArgs(headless));
		
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		driver = new ChromeDriver(driverOptions);
		
		driver.get(url);
		
		//Clicking Column dropdown and removing ID column
		AngularUI.column_Dropdown(driver).click();
		AngularUI.column_Dropdown_ID_Column(driver).click();
		
		//Searching for ID Column and selecting it again 
		AngularUI.Search_Box(driver).sendKeys("id");
		AngularUI.column_Dropdown_ID_Column(driver).click();
		
		//Storing ID Column reference and checking if it exists.
		tempElement = AngularUI.ID_Column(driver);
		result = AutomationLogic.isElementDisplayed(tempElement);
		
		//Failing test if column does not exist.
		if(!result) {
			fail("The ID Column was not found on the page and it was expected to be there.");
		}
		
		driver.close();
	}
	
}