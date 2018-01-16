package com.TestWithMaven;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Withdraw extends BasePage{
	
	
	@FindBy(linkText = "Withdrawal")
	WebElement cashWithdrawalPage;
	
	@FindBy(name = "accountno") 
	WebElement accNum;
	
	@FindBy(name = "ammount") 
	WebElement cAmmount;
	
	@FindBy(name = "desc")
	WebElement aDescription;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(css = "#withdraw > tbody:nth-child(1) > tr:nth-child(12) > td:nth-child(2)")
	WebElement debitedAmount;
	
	@FindBy(linkText = "Continue")
	WebElement contBtn;
	
	public void _openWithdrawalPage() {
		
		cashWithdrawalPage.click();
	}
	
	
	
	public void _withdrawAmmount (String _aValue, String _dValue) {
		
		AccountID accID = new AccountID();
		
		accNum.sendKeys(accID.getAccountID());
		
		cAmmount.sendKeys(_aValue);
		
		aDescription.sendKeys(_dValue);
		
		submitBtn.click();
		
		_verifyWithdrawalAmmount(_aValue);
		
		contBtn.click();
		
	}
	
	
	private void _verifyWithdrawalAmmount(String _aValue) {
		
		if (debitedAmount.getText().toString().equalsIgnoreCase(_aValue)) {
			
			System.out.println("Test Passed: Debited Correct Amount!");
		}
		else
			System.out.println("Test Failed: Debited Wrong Amount!\nDisplayed Amount: R" + debitedAmount.getText() + "\nActual Amount: R" + _aValue);
	
	}
	
}