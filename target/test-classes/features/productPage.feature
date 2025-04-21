
Feature: Products page in saucedemo  

Background:
Given User is logged into the app

#Scenario: User should be able to click on the Product and be in the product overview page
#Given the user is on the Products page
#When the user clicks on the "Sauce Labs Backpack" 
#Then the user is taken to the product overview page


#Scenario: User should be able to Add the product to the cart
#Given the user is on the Products page
#When the user clicks on the Add to cart button on the product
#Then the product needs to get added to the cart

#Scenario: User should be able to click on the checkout button
#Given the user has a product in the cart
#When the user clicks on "Checkout" button
#Then the user reached the "Checkout: Your Information" page

#Scenario: User should be able to remove the item from the cart
#Given the user has a product in the cart
#When the user clicks on "Remove" button
#Then the item should get removed from the cart

Scenario: User trying to access the inventory page without logging in
Given the user is logged out of the app
When the user tried to access the link "https://www.saucedemo.com/inventory.html"
Then the user should see the error message "Epic sadface"