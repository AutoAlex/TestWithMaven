package com.TestWithMaven;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FundTransfer extends BasePage {
	
	
	@FindBy(linkText = "Fund Transfer")
	WebElement fundTransferPage;
	
	@FindBy(name = "payersaccount")
	WebElement payersAccNum;
	
	@FindBy(name = "payeeaccount")
	WebElement payeesAccNum;
	
	@FindBy(name = "ammount")
	WebElement fundAmount;
	
	@FindBy(name = "desc")
	WebElement desc;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(css = ".layout > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(3) > td:nth-child(2)")
	WebElement transferedAmount;
	
	@FindBy(linkText = "Continue")
	WebElement contBtn;
	
	
	public void _openFundTransferPage() {
		
		fundTransferPage.click();
		
	}
	
	
	public void _transferFunds(String payeesAccNo, String ammount, String description) {
		
		
		AccountID tAccount = new AccountID();
		
		payersAccNum.sendKeys(tAccount.getAccountID());
		
		payeesAccNum.sendKeys(payeesAccNo);
		
		fundAmount.sendKeys(ammount);
		
		desc.sendKeys(description);
		
		submitBtn.click();
		
		_verifySentAmount(ammount);
		
		contBtn.click();
		
		
	}
	
	
	private void _verifySentAmount(String ammount) {
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		if (transferedAmount.getText().toString().equalsIgnoreCase(ammount)) {
			
			System.out.println("Test Passed! Transfer Successful");
		}
		else
			System.out.println("Test Failed! Transfer Unsuccessful\nDisplayed Amount: R" + transferedAmount.getText() + "\nActual Amount: R" + ammount);
			
	}
	
}