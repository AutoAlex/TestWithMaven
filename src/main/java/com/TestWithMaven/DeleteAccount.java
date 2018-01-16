package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class DeleteAccount extends BasePage{
	
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(linkText = "Delete Account")
	WebElement deleteAccount;
	
	public void _openDeleteAccountPage () {
		
		deleteAccount.click();
	}
	
	
	
	public void _deleteAccount () {
		
		AccountID accID = new AccountID();
		
		accountNo.sendKeys(accID.getAccountID());
		
		submitBtn.click();
		
		driver.switchTo().alert().accept();
		
		//driver.close();
	}
}