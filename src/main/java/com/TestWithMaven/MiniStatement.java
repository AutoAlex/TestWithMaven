package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MiniStatement extends BasePage{
	
	
	@FindBy(name = "accountno") 
	WebElement accNum;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(linkText = "Mini Statement")
	WebElement miniStatementPage;
	
	@FindBy(css = ".heading3")
	WebElement heading;
	
	@FindBy(linkText = "Continue")
	WebElement contBtn;
	
	public void _openMiniStatementPage () {
		
		miniStatementPage.click();
	}
	
	
	public void _checkMiniStatement() {
		
		AccountID accID = new AccountID();
		
		accNum.sendKeys(accID.getAccountID());
		
		submitBtn.click();
		
		_verifyHeading();
		
		contBtn.click();
	}
	
	
	private void _verifyHeading() {
		
		AccountID accID = new AccountID();
		
		if (heading.getText().toString().equalsIgnoreCase("Last Five Transaction Details for Account No: " + accID.getAccountID()) ) {
			
			System.out.println("Test Passed. Mini Statement is displayed");
		}
		else
			System.out.println("Test Failed. Mini Statement is not displayed/displed properly");
	}
	
	
	
}