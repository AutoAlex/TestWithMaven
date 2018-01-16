package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BalanceEnquiry extends BasePage {
	
	
	@FindBy(name = "accountno")
	WebElement accNum;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(linkText = "Balance Enquiry")
	WebElement bEnquiry;
	
	@FindBy(css = ".heading3")
	WebElement bHeading;
	
	@FindBy(linkText = "Continue")
	WebElement contBtn;
	
	public void _openBalanceEnquiryPage() {
		
		bEnquiry.click();
	}
	
	
	
	public void _checkBalanceEnquiry() {
		
		
		AccountID accID = new AccountID();
		
		accNum.sendKeys(accID.getAccountID());
		
		submitBtn.click();
		
		_verifyBalanceEnquiry();
		
		contBtn.click();
	}
	
	
	private void _verifyBalanceEnquiry() {
		
		AccountID accID = new AccountID();
		
		if (bHeading.getText().toString().equalsIgnoreCase("Balance Details for Account " + accID.getAccountID()) ) {
			
			System.out.println("Test Passed!! Balance Enquiry Title Displayed Accurately.");
		}
		else
			System.out.println("Test Failed!! Balance Enquiry Title Not Displayed Accurately.\nDisplayed text: " 
		+ bHeading.getText() + "\nActual Text: " 
		+ "Balance Details for Account " 
		+ accID.getAccountID());
	}
	
	
}