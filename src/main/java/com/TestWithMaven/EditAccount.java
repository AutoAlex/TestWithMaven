package com.TestWithMaven;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


public class EditAccount extends BasePage {
	
	@FindBy(linkText = "Edit Account")
	WebElement editAccountPage;
	
	@FindBy(name = "accountno")
	WebElement accountNo;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(name = "a_type")
	WebElement accountType;
	
	@FindBy(css = "#account > tbody:nth-child(1) > tr:nth-child(8) > td:nth-child(2)")
	WebElement displayedAccType;
	
	@FindBy(linkText = "Log out")
	WebElement logoutBtn;
	

	
	
	
	public void _openEditAccountPage() {
		
		editAccountPage.click();
			
	}
	
	public void _editAccount(String _value)   {
		
		
		try {
			
			
			AccountID accID = new AccountID();
			String text;
			
			text = accID.getAccountID();
			

			//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			
			accountNo.sendKeys(text);
			
			
			
			submitBtn.click();
			
			WebElement mySelection = accountType;
			Select dropdown = new Select(mySelection);
			
			dropdown.selectByValue(_value);
			
			submitBtn.click();
				
			//if (displayedAccType.getText() == _value) {
				
				//System.out.println("Account Edit Successfull!!");
			//}
			
			logoutBtn.click();
			
			driver.switchTo().alert().accept();
	
		}
		catch (Exception e) {
			System.out.println(e.getMessage() + "Error Occured.");
		}
	}
	
}