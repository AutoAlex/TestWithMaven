Feature: Bank Account

Scenario: Create and Edit Account
Given the browser has started on the right link
When the user enters "mngr112006" and "upYvezA"
Then the user opens new Account page
And creates "Current" account and deposits "500"
And opens edit Account page
And Changes Bank Account Type to "Savings"

Scenario: Deposit Cash in Accountt
Given the browser has started on the right link
When the user enters "mngr112006" and "upYvezA"
Then the user opens Deposit page
And deposits "500" into new "BankAccount"

Scenario: Withdraw Cash from Account
When the user opens Withdrawal page
Then the user withdraws "200" from Bank Account for "Petrol"

Scenario: Transfer Cash to different account
When the user opens Fund Transfer page
Then From Account "36572" transfers "100" to "Wife's Account"

Scenario: Check balance
When the user opens Balance Enquiry Page
Then Checks Balance Enquiry

Scenario: View Mini Statement
When the user opens Mini Statement
Then Checks Mini Statement
