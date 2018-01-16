package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class Login extends BasePage {
	
	@FindBy(name = "uid")
	WebElement userID;
	
	@FindBy(name = "password")
	WebElement userPw;
	
	@FindBy(name = "btnLogin")
	WebElement loginBtn;

   // @FindBy(linkText = "Log out")
   // WebElement logoutBtn;
	 
	public void _userLogin (String userName, String password) {
		
		
		if (userID.isDisplayed()) {

			userID.sendKeys(new String[] {userName});
			userPw.sendKeys(new String[] {password});
			loginBtn.click();
		}
    }

    public void _checkBrowser() {

        if (driver.getCurrentUrl().equalsIgnoreCase("http://www.demo.guru99.com/v4/")) {

            System.out.println("Link Opened Successfully");
           // logoutBtn.click();
        }
    }
}
