package com.TestWithMaven;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeleteCustomer extends BasePage {
	
	
	@FindBy(name = "cusid")
	WebElement customerID;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn;
	
	@FindBy(linkText = "Delete Customer")
	WebElement deleteCustomer;
	
	@FindBy(className = "heading3")
	WebElement pageHeading;
	
	public void _openDeleteCustomerPage() throws Exception {
			
		deleteCustomer.click();
			
	}
	
	
	public void _deleteCustomer ()  {
		
		CustomerID custid = new CustomerID();
	
			
		if(pageHeading.isDisplayed()) {
			   
			   System.out.println("EditCustomerPage Displayed");
			   
			   if (customerID.isDisplayed()) {
				   
				   customerID.sendKeys(custid.getCustomerID());
				   submitBtn.click();
				   
				   driver.switchTo().alert().accept();				  			   
			   }
			   else
			   {
				   System.out.println("CustomerID Not Found!");
			   }
		}
		
		//driver.close();
	}
}