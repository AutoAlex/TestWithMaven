package com.TestWithMaven;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



import java.util.Random;



public class EditCustomer extends BasePage {
	
	@FindBy(linkText = "Edit Customer")
	WebElement editCustomerPage;
	
	@FindBy(className = "heading3")
	WebElement pageHeading;
	
	@FindBy(name = "cusid")
	WebElement customerID;
	
	@FindBy(name = "AccSubmit")
	WebElement submitBtn; 
	
	@FindBy(name = "addr")
	WebElement customerAddr;
	
	@FindBy(name = "city")
	WebElement customerCity;
	
	@FindBy(name = "state")
	WebElement customerState;
	
	@FindBy(name = "pinno")
	WebElement customerPin;
	
	@FindBy(name = "telephoneno")
	WebElement customerPhone;
	
	@FindBy(name = "emailid")
	WebElement customerEmail;
	
	@FindBy(name = "sub")
	WebElement customerSubBtn;
	
	@FindBy(linkText = "Log out")
	WebElement logoutBtn;

    @FindBy(css = "#customer > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")
    WebElement displayedCustID;

    @FindBy(name = "cusid")
    WebElement cID;

    @FindBy(name = "AccSubmit")
    WebElement subBtn;
	
	
	public void _openEditCustomer () {

        CustomerID accID = new CustomerID();

		editCustomerPage.click();
        cID.sendKeys(accID.getCustomerID());

        subBtn.click();
	}
	
	
	
	public void _verifyEditCustomerPage () {
		
		
		CustomerID custid = new CustomerID();
		
		if(pageHeading.isDisplayed()) {
			   
			   System.out.println("EditCustomerPage Displayed.");
			   
			   if (customerID.isDisplayed()) {
				   
				   customerID.sendKeys(custid.getCustomerID());
				   submitBtn.click();
			   }
			   else
			   {
				   System.out.println("EditCustomerID Not Found!");
			   }
			   
		   }
		   else
		   {
			   System.out.println("EditCustomerPage Not Found!");
		   }
	}
	
	
	
	public void _editCustomer(int data, String _value) {
		
		
		switch (data) {
				
				case 0:
					customerAddr.sendKeys(_value);
					break;
					
				case 1:
					customerCity.sendKeys(_value);
					break;
				
				case 2:
					customerState.sendKeys(_value);
					break;
					
				case 3:
					customerPin.sendKeys(_value);
					break;
					
				case 4:
					customerPhone.sendKeys(_value);
					break;
					
				case 5:
					customerEmail.sendKeys(_generateEmail());
					customerSubBtn.click();
					
					//Handles Unhandled Exception that occurs as a result of the prior step
					Alert alert = driver.switchTo().alert();
					alert.accept();
					logoutBtn.click();
					driver.switchTo().alert().accept();
					break;
					
				default:
					System.out.println("Fill in all elements.");
					break;
				}
	}
	
	
	public String _generateEmail () {
		
		
		Random randomNum = new Random();
		
		int rnd;
		
		rnd = randomNum.nextInt(19);
		
		if (rnd <= 0) {
			rnd = rnd + 2 * 2;
		}
		
		return RandomStringUtils.random(rnd, "abcdefghijklmnopqrstuvwxyz") + "@gmail.com";
	}

    public void _saveCustomerID () {

        try {
            String custID;

            CustomerID custid = new CustomerID();

            custID = displayedCustID.getText();

            //driver.switchTo().alert().accept();

            custid.setCustomerID(custID);

        }
        catch (NoAlertPresentException e)
        {
            System.out.println(e.getMessage() + " Exception Occurred.");
        }
    }
}