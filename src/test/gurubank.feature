Feature: Guru99Bank Manager Login and Customer Creation
Scenario: Valid Login
Given I insert username "mngr112006" and password "upYvezA"
Then "mngr95915" is displayed


Scenario: Create and Edit Customer
Given I insert username "mngr112006" and password "upYvezA"
Given I am on the Welcome page
Then I select New Customer page
Given I am on the New Customer page 
Then Read table to Add Details
	| Alex | 	f   | 15/09/1956 | Mercury | CapeTown | Western Cape | 456556 | 1581581581 | alex@automytest.com | pa55word |
Then I select Edit Customer page
Given I am on the Edit Customer page search for customer
Then Read table to Edit Details
	| Bellville | CapeTown | Western Cape | 456556 | 1581581581 | alex@automytest.com |


Scenario: Create and Edit Account
Given I insert username "mngr112006" and password "upYvezA"
Then I open new Account page
Then I create "Current" account and deposit "500"
Then I open edit Account page
And Change Bank Account Type to "Savings"

Scenario: Deposit and Withdraw Cash from Account
Given I insert username "mngr112006" and password "upYvezA"
Then Open Deposit page
Then Deposit "500" into new "BankAccount"
Then Open Withdrawal page
And Withdraw "200" from Bank Account for "Petrol"

Scenario: Transfer Cash to different account
Then Open Fund Transfer page
And From Account "32816" transfer "100" to "Wife's Account"

Scenario: Check balance and View Mini Statement
Then Open Balance Enquiry Page
And Check Balance Enquiry
Then Open Mini Statement
And Check Mini Statement
