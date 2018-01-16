package com.TestWithMaven;

import java.util.List;

import com.TestWithMaven.BalanceEnquiry;
import com.TestWithMaven.BasePage;
import com.TestWithMaven.CustomizedStatement;
import com.TestWithMaven.DeleteAccount;
import com.TestWithMaven.DeleteCustomer;
import com.TestWithMaven.Deposit;
import com.TestWithMaven.EditAccount;
import com.TestWithMaven.EditCustomer;
import com.TestWithMaven.FundTransfer;
import com.TestWithMaven.Login;
import com.TestWithMaven.Manager;
import com.TestWithMaven.MiniStatement;
import com.TestWithMaven.NewAccount;
import com.TestWithMaven.NewCustomer;
import com.TestWithMaven.Withdraw;

import cucumber.api.DataTable;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.After;


public class Annotation  {
   List<List<String>> data;
   String value;

   //User-Login
   @When("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
   public void login(String user, String pW) { 

	   Login uLogin = new Login();  
	   uLogin._userLogin(user, pW);
   }
   
   @Given("^the browser has started on the right link$")
   public void checkBrowser() {

       Login uLogin = new Login();
       uLogin._checkBrowser();
   }

    //Verify-ManagerI
    @Then("^\"([^\"]*)\" is displayed on Manager page$")
    public void verifyLogin(String mngrId) {

        Manager uManager = new Manager();
        uManager._verifyLogin(mngrId);
    }



   //Verify-WelcomePage
   @Then("^the user lands on Welcome page$")
   public void verifyManager() {
	   
	   Manager uManager = new Manager();
	   uManager._verifyManagerPage();
   }
   
   
   
   
   //Open-CustomerPage
   @And("^selects New Customer page$")
   public void newCustomer() {
	   
	  NewCustomer uCustomer = new NewCustomer();
	  uCustomer._openNewCustomerPage();
   }
   
   
   
   
   //Verify-NewCustomerPage
   @Given("^the user is on the New Customer page$")
   public void verifyNewCustomerPage() {
	   
	   NewCustomer uCustomer = new NewCustomer();   
	   uCustomer._verifyCustomerPage();   
   }
   
   
   

   @When("^the user enters customer details$")
   public void addCustomerDetails(DataTable det) throws Throwable {
	   	   
	   NewCustomer uCustomer = new NewCustomer();
      // AccountID accID = new AccountID();
	   
	   data = det.raw();
	   for (int num = 0; num <= 9; num++) {
		   
		  value = data.get(0).get(num);		  
		  uCustomer._newCustomer(num, this.value); 
	   	}	   
	   
	   uCustomer._saveCustomerID();
      // System.out.println("New Customer: " + accID.getAccountID());
   }
   
   
   @Then("^customer is created successfully$")
   public void validateNewCustomer() {

       AccountID accID = new AccountID();

       if (accID.getAccountID() != null){
           System.out.println("Customer Validation: " + accID.getAccountID());
       }
   }
   
  @Given("^the user is on the Edit Customer page$")
   public void editCustomer() {
	   
	   EditCustomer uCustomer = new EditCustomer();
       uCustomer._saveCustomerID();
	   uCustomer._openEditCustomer();

   }
   
   

   @Given("^I am on the Edit Customer page search for customer$")
   public void verifyEditCustomerPage() throws Exception {
	   
	   EditCustomer uCustomer = new EditCustomer();    
	   uCustomer._verifyEditCustomerPage();
   }
   

   @When("^the user searches for customer and edits details$")
   public void editCustomerDetails(DataTable det) throws Throwable {
	   
	   EditCustomer uCustomer = new EditCustomer();
	   CustomerID custID = new CustomerID();



	   data = det.raw(); 	 
	   for (int num = 0; num <= 5; num++) {
		   
		   value = data.get(0).get(num);	   
		   uCustomer._editCustomer(num, value);
	   }
   }
   
   @Then("^customer details are edited$")
   public void _validateCustEdit() {

       System.out.println("^Customer edited Successfully");
   }
   
   
   @And("^Delete a customer$") 
   public void customerDelete() throws Exception {
   
   DeleteCustomer uCustomer = new DeleteCustomer();
 
   uCustomer._openDeleteCustomerPage();   
   uCustomer._deleteCustomer();
   }
   
   
   
   
   @Then("^the user opens new Account page$")
   public void _openNewAccountPage() {
	   
	   NewAccount nAccount = new NewAccount();	   
	   nAccount._openNewAccountPage();
   }
   
   
   @And("^opens edit Account page$")
   public void _openEditAccountPage() {
	   
	   EditAccount nAccount = new EditAccount();   
	   nAccount._openEditAccountPage();
   }
   

   
   @And("^creates \"([^\"]*)\" account and deposits \"([^\"]*)\"$")
   public void _createAccount (String _value, String _deposit) {
	   
	   NewAccount nAccount = new NewAccount();	   
	   nAccount._addNewAccount(_value, _deposit);
   }
   
  
   
   
   @And("^Changes Bank Account Type to \"([^\"]*)\"$")
   public void _editBankAccount(String _value) {
	   
	   EditAccount nAccount = new EditAccount(); 
	   nAccount._editAccount(_value);
   }
   
   
   @Then("^Delete Bank Account$") 
   public void _deleteAccount() {
	   
	   DeleteAccount dAccount = new DeleteAccount();  
	   dAccount._deleteAccount();   
   }
   
   
   @Then("^the user opens Deposit page$")
   public void _openDepositPage() {
	   
	   Deposit deposit = new Deposit();
	   deposit._openDepositPage();
   }
   
   
   @And("^deposits \"([^\"]*)\" into new \"([^\"]*)\"$")
   public void _depositCash(String _aValue, String _dValue) {
	   
	   Deposit deposit = new Deposit();
	   deposit._depositCash(_aValue, _dValue);  
   }
   
   
   
   @When("^the user opens Withdrawal page$")
   public void _openWithdrawalPage() {
	   
	   Withdraw wPage = new Withdraw();
	   wPage._openWithdrawalPage();
   }
   
   
   
   
   @Then("^the user withdraws \"([^\"]*)\" from Bank Account for \"([^\"]*)\"$")
   public void _withdrawCash(String _aValue, String _dValue) {
	   
	   Withdraw wAmount = new Withdraw();	   
	   wAmount._withdrawAmmount(_aValue, _dValue);
   } 
   
   
   @When("^the user opens Fund Transfer page$")
   public void _openFundTranserPage() {
	   
	   FundTransfer fTransfer = new FundTransfer();	   
	   fTransfer._openFundTransferPage();
   }
   

   @Then("^From Account \"([^\"]*)\" transfers \"([^\"]*)\" to \"([^\"]*)\"$")
   public void _transferCash(String _accNum, String _value, String _description) {
	   
	   FundTransfer fTransfer = new FundTransfer();   
	   fTransfer._transferFunds(_accNum, _value, _description);
   }
   
   
   @When("^the user opens Balance Enquiry Page$")
   public void _openBalanceEnquiry() {
	   
	   BalanceEnquiry bEnquiry = new BalanceEnquiry();   
	   bEnquiry._openBalanceEnquiryPage();
   }
   
   
   
   @Then("^Checks Balance Enquiry$")
   public void _checkBalanceEnquiry() {
	   
	   BalanceEnquiry bEnquiry = new BalanceEnquiry(); 
	   bEnquiry._checkBalanceEnquiry();
   }
   
   
   @When("^the user opens Mini Statement$")
   public void _openMiniEnquiry() {
	   
	   MiniStatement mStatement = new MiniStatement();   
	   mStatement._openMiniStatementPage();
   }
   
   
   @Then("^Checks Mini Statement$")
   public void _checkMiniStatement() {
	   
	   MiniStatement mStatement = new MiniStatement();   
	   mStatement._checkMiniStatement();
   }
   
   
   @Then ("^Open Customized Statement page$")
   public void _openCustomizedStatement() {
	   
	   CustomizedStatement cStatement = new CustomizedStatement();	   
	   cStatement._openCustomizedStatement();
   }
   
   
   //Create class for Number of transaction and call an object that will always access the object
  @And("^Check Customized statement$")
  public void _checkCustomizedStatement(String _fdate, String _tdate, String _minValue) {
	  
	  CustomizedStatement cStatement = new CustomizedStatement();
	  cStatement._checkCustomizedStatement(_fdate, _tdate, _minValue);
  }

}

