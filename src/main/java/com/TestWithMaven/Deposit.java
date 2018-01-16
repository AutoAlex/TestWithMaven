package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Deposit extends BasePage {
	
	@FindBy(linkText = "Deposit")
	WebElement cashDeposit;
	
	@FindBy(name = "accountno")
	WebElement accNum;
	
	@FindBy(name = "ammount") 
	WebElement cAmmount;
	
	@FindBy(name = "desc")
	WebElement aDesc;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(css = "#deposit > tbody:nth-child(1) > tr:nth-child(12) > td:nth-child(2)")
	WebElement creditedAmmount;
	
	@FindBy(linkText = "Continue")
	WebElement contBtn;
	
	
	public void _openDepositPage () {
		
		
		cashDeposit.click();	
		}
		

	
	
	public void _depositCash (String _aValue, String _dValue ) {
		
		
		
		AccountID accID = new AccountID();
		
		accNum.sendKeys(accID.getAccountID());
		
		cAmmount.sendKeys(_aValue);
		
		aDesc.sendKeys(_dValue);
		
		submitBtn.click();
		
		_verifyTransAmmount(_aValue);
		
		contBtn.click();
	}
	
	
	private void _verifyTransAmmount (String _aValue) {
		
		if (creditedAmmount.getText().toString().equalsIgnoreCase(_aValue)) {
			
			System.out.println("Test Passed: Credited Correct Amount!");
		}
		else {
			
			System.out.println("Test Failed: Credited Incorrect Amount!" 
			+"\nDisplayed Amount: R" + creditedAmmount.getText().toString() 
			+ "\nActual Amount: R" + _aValue);
		}
	}
	
		
}