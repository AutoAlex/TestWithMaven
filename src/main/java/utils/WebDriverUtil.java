package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

/**
 * Created by sriramangajala on 08/11/16.
 */
public class WebDriverUtil {
	
	public static boolean isTextPresent(String text) {
		
		try {
			return BrowserFactory.getDriver().findElement(By.tagName("body")).getText().contains(text);
		}
		catch (StaleElementReferenceException e)
		{
			return false;
		}
	}
	
	
	public static boolean waitForText(String text) {
		
		int timeCounter = 0;
		
		while(!isTextPresent(text) && AutomationConstants.MAX_TIMEOUTS>timeCounter)
		{
			try {
				System.out.println("Waiting for 1 sec");
				Thread.sleep(1000);
			}
			catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			timeCounter++;
		}
		return isTextPresent(text);
	}
}