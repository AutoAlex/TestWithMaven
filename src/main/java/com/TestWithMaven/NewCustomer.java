package com.TestWithMaven;


import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.RandomStringUtils;

import org.openqa.selenium.NoAlertPresentException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

//import com.TestWithMaven.Annotation.PageData;


public class NewCustomer extends BasePage {
	
	@FindBy(linkText = "New Customer")
	WebElement newCustomerPage;
	
	@FindBy(className = "heading3")
	WebElement pageHeading;


	@FindBy(name = "name")
	WebElement customerName;

	@FindBy(css = "input[value='f']")
	WebElement gender;
	
	@FindBy(name = "dob")
	WebElement customerDOB;
	
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
	
	@FindBy(name = "password")
	WebElement customerPW;
	
	@FindBy(name = "sub")
	WebElement custSubBtn;
	
	
	@FindBy(css = "#customer > tbody:nth-child(1) > tr:nth-child(4) > td:nth-child(2)")
	WebElement displayedCustID;
	
	
	
	
	public void _openNewCustomerPage() {

		newCustomerPage.click();
	}
	
	
	
	public void _verifyCustomerPage() {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		   
		if(pageHeading.isDisplayed()) {
			   
			System.out.println("New Customer Displayed");
	    }
        else
            newCustomerPage.click();
	}
	
	
	public void _newCustomer(int data, String value) {
		
		
		switch (data) {
		
		case 0:
			customerName.sendKeys(new String[] {value});
			break;
		
		case 1:
			gender.click();
			break;
			
		case 2:
			customerDOB.sendKeys(new String[] {value});
			break;
			
		case 3:
			customerAddr.sendKeys(new String[] {value});
			break;
			
		case 4:
			customerCity.sendKeys(new String[] {value});
			break;
		
		case 5:
			customerState.sendKeys(new String[] {value});
			break;
			
		case 6:
			customerPin.sendKeys(new String[] {value});
			break;
			
		case 7:
			customerPhone.sendKeys(new String[] {value});
			break;
			
		case 8:
			value = _generateEmail();
			customerEmail.sendKeys(new String[] {value});
			break;
			
		case 9:
			customerPW.sendKeys(new String[] {value});
			custSubBtn.click();
			break;
			
		default:
			System.out.println("Fill in all elements.");
			break;	
		}	
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
	
	
	
	public String _generateEmail () {
		
		Random randomNum = new Random();
		
		int rnd;
		
		rnd = randomNum.nextInt(19);
		
		if (rnd <= 0) {
			rnd = rnd + 2 * 2;
		}
		
		return RandomStringUtils.random(rnd, "abcdefghijklmnopqrstuvwxyz") + "@gmail.com";
	
	}
	
	
	
}