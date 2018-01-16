package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CustomizedStatement extends BasePage {
	
	@FindBy(name = "accountno")
	WebElement accNum;
	
	@FindBy(name = "fdate")
	WebElement fDate;
	
	@FindBy(name = "tdate")
	WebElement tDate;
	
	@FindBy(name = "amountlowerlimit")
	WebElement minVal;
	
	@FindBy(name = "numtransaction")
	WebElement transNum;
	
	@FindBy(linkText = "Customised Statement")
	WebElement CustStatementPage;
	
	@FindBy(name = "AccSubmit")
	WebElement subButton;
	
	
	
	public void _openCustomizedStatement() {
		
		CustStatementPage.click();
	}
	
	
	
	public void _checkCustomizedStatement(String _fdate, String _tdate, String _minValue) {
		
		AccountID accID = new AccountID();
		
		accNum.sendKeys(accID.getAccountID());
		
		fDate.sendKeys(_fdate);
		
		tDate.sendKeys(_tdate);
		
		minVal.sendKeys(_minValue);
		  
        subButton.click();
	}
	
}