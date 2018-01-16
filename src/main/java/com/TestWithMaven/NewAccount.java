package com.TestWithMaven;




import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class NewAccount extends BasePage {
	
	@FindBy(linkText = "New Account")
	WebElement createAccPage;
	
	@FindBy(name = "cusid")
	WebElement customerID;
	
	@FindBy(name = "selaccount")
	WebElement accountType;
	
	@FindBy(name = "inideposit")
	WebElement cashDeposit;
	
	@FindBy(name = "button2")
	WebElement submitBtn;
	
	@FindBy(css = "#account > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")
	WebElement displayedAccType;
	
	
	
	public void _openNewAccountPage () {
		
		createAccPage.click();
	
		//Marionete driver(gecko) throws Exception at this point unless an the LinkText is clicked twice.
		createAccPage.click();
	}
	
	
	
	public void _addNewAccount(String _value, String _deposit) {
		
		CustomerID custID = new CustomerID();
		
		
		customerID.sendKeys(custID.getCustomerID());
		
		WebElement mySelection = accountType;
		Select dropdown = new Select(mySelection);
		
		dropdown.selectByValue(_value);
		
		cashDeposit.sendKeys(_deposit);
		
		submitBtn.click();
		
		_saveAccountID();
		
	}
	
	
	
	private void  _saveAccountID () {
	
		AccountID accID = new AccountID();
		
		String accountID = displayedAccType.getText();
		
		accID.setAccountID(accountID);
		
	}
	
}