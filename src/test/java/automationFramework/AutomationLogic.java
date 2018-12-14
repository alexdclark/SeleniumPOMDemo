/**
 * 
 */
package automationFramework;

import org.openqa.selenium.WebElement;

/**
 * @author clarkald
 *
 */
public class AutomationLogic {

	static boolean displayed = false;
	
	//Function that returns the correct Chrome Argument depending on headlessToggle
			public static String getArgs(boolean headlessOption) {
				if (headlessOption) {
					return "--headless";
				}

				else {
					return "--start-maximized";
				}
			}
			
	public static boolean isElementDisplayed(WebElement element) {
		
		try {
			displayed = element.isDisplayed();
			System.out.println("The element was displayed");
			displayed = true;
		}
		
		catch(Exception e){
			System.out.println("The element was not displayed");
			displayed = false;
		}
		
		return displayed;
	}
	
}
