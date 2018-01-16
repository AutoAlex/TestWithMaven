Feature: Bank Customer
A bank manager should be able to create new customer and edit customer details

Scenario: Open New Customer page
Given the browser has started on the right link
When the user enters "mngr112006" and "upYvezA"
Then the user lands on Welcome page
And selects New Customer page

Scenario: Create a new Customer
Given the user is on the New Customer page
When the user enters customer details
	| Alex | 	f   | 15/09/1956 | Mercury | CapeTown | Western Cape | 456556 | 1581581581 | alex@automytest.com | pa55word |
Then customer is created successfully

Scenario: Edit Customer details
Given the user is on the Edit Customer page
When the user searches for customer and edits details
	| Bellville | CapeTown | Western Cape | 456556 | 1581581581 | alex@automytest.com |
Then customer details are edited