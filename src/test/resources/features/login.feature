@WebTest
Feature: Login into SauceDemo app

Scenario: Login as a Locked out user
Given the user is on the login page "https://www.saucedemo.com/"
When the user enters username "locked_out_user" and password "secret_sauce"
And the user clicks on the login button
Then the user should see the error message "Epic sadface: Sorry, this user has been locked out."

Scenario: Successful login with the valid credentials
Given the user is on the login page "https://www.saucedemo.com/"
When the user enters username "standard_user" and password "secret_sauce"
And the user clicks on the login button
Then the user should land on the products page and see the title "Swag Labs"