package com.TestWithMaven;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import utils.AutomationConstants;
import utils.BrowserFactory;


import java.util.concurrent.TimeUnit;

/**
 * Created by pc on 04-Feb-17.
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucmber.json"},
        features= "src/test/resources"
)
public class RunTest { 
	
	static WebDriver driver;
	
	@BeforeClass
	public static void start() {
		
		try {
			
			BrowserFactory.OpenBrowser(AutomationConstants.BROWSER_TYPE, AutomationConstants.URL);
			driver = BrowserFactory.driver;
			driver.manage().timeouts().implicitlyWait(AutomationConstants.MAX_TIMEOUTS, TimeUnit.SECONDS);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public static void stop() throws InterruptedException {
		
		Thread.sleep(5000);
		BrowserFactory.closeBrowser();
	}
}