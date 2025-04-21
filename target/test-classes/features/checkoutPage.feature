Feature: Checkout page

Background: 
Given User has clicked on the checkout button

Scenario: User leaves the mandatory field blank and gets error message
Given the user is on checkout information page
When the user fills in the below information
| Last Name | Zip/Postal Code |
 | Cruise    | AB1234          |
And clicks on "Continue" button
Then the user should receive an error message "Error: First Name is required"

Scenario: User should fill in the user information and reach the checkout overview page
Given the user is on checkout information page
When the user fills in the below information
| First Name | Last Name | Zip/Postal Code |
 | Tom        | Cruise    | AB1234          |
And finally clicks on finish button
Then the user should see the "Thank you for your order!" message

Scenario: User should be able to go back from checkout page to continue shopping
Given the user is on checkout information page
When the user clicks on "Cancel" button
And the user clicks on "Continue Shopping" button
Then the user should land on the products page and see the title "Swag Labs"


