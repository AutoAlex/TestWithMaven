package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Manager extends BasePage{
	
	@FindBy(xpath = "/html/body/table/tbody/tr/td/center/img[2]")
	WebElement pageImage;
	
	@FindBy(tagName = "tbody")
	WebElement pageMessage;
	
	@FindBy(linkText = "Log out")
	WebElement logoutBtn;

	
	public void _verifyManagerPage () {
		
		if(pageImage.isDisplayed()) {
		   	   
			   System.out.println("On Welcome Page");
			   
		}   
	}
	
	
	
	public void _verifyLogin(String manager) {
		
		
		if(pageImage.isDisplayed()) {
			   
			   String text;
			   text = pageMessage.getText();
			   
			   if(text.toLowerCase().indexOf(manager.toLowerCase()) != -1) {
				   
				   System.out.println("Test Passed: Login Successful");
			   }
			   else{
				   System.out.println("Test Failed: Login Unsuccessful");
			   }
			   
		   }
			logoutBtn.click();
			driver.switchTo().alert().accept();
			
			
			
		   //driver.close();
	}
}