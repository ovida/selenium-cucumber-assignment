package stepDefinition;

import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;
import pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.BrowserDriver;
import utility.CommonStepsUtil;

public class ProductPageStep {
	
	LoginPage loginPage = new LoginPage();
	ProductPage productPage= new ProductPage();
	
	
	@Given("User is logged into the app")
	public void user_is_logged_into_the_app() {
		loginPage.launchLoginPage("https://www.saucedemo.com/");
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickButton();
	   productPage.verifyTitle("Swag Labs");
	}

	@Given("the user is on the Products page")
	public void the_user_is_on_the_products_page() {
		productPage.verifySubTitle("Products");
	}
	

	@When("the user clicks on the {string}")
	public void the_user_clicks_on_the(String string) {
//		productPage.clickOn("Sauce Labs Backpack");
		productPage.clickOnById("add-to-cart-sauce-labs-backpack");
	}

	@Then("the user is taken to the product overview page")
	public void the_user_is_taken_to_the_product_overview_page() throws InterruptedException {
	   productPage.verifyTitle();
	   BrowserDriver.quitDriver();
	}
	

	@When("the user clicks on the Add to cart button on the product")
	public void the_user_clicks_on_the_Add_to_cartbutton_on_the_product() {
	    
		productPage.clickAddToCartButton();
	}

	@Then("the product needs to get added to the cart")
	public void the_product_needs_to_get_added_to_the_cart() throws InterruptedException  {
		productPage.cartUpdated();
		productPage.goToCart();
		productPage.verifyCart("div.cart_item div[data-test='inventory-item-name']");
		
	}
	

	@Given("the user has a product in the cart")
	public void the_user_has_a_product_in_the_cart() throws InterruptedException {
		productPage.clickAddToCartButton();
		productPage.goToCart();
		productPage.verifyCart("div.cart_item div[data-test='inventory-item-name']");
		
	}


//	@When("the user clicks on the {string} button")
//	public void the_user_clicks_on_button(String buttonName) {
//		productPage.clickOnById("remove-sauce-labs-backpack");
//	  
//	}

	@Then("the user reached the {string} page")
	public void the_user_reached_the_page(String string) {
		productPage.verifySubTitle(string);
		BrowserDriver.quitDriver();
	}

	@Then("the item should get removed from the cart")
	public void the_item_should_get_removed_from_the_cart() throws InterruptedException {
		//productPage.verifyCart("div.cart_item div[data-test='inventory-item-name']");
		productPage.goToCart();
		productPage.verifyCartEmpty("div.cart_item div[data-test='inventory-item-name']");
		BrowserDriver.quitDriver();
	}


	@Given("the user is logged out of the app")
	public void the_user_is_logged_out_of_the_app() {
		productPage.logout();
	}

	@When("the user tried to access the link {string}")
	public void the_user_tried_to_access_the_link(String url) {
		loginPage.launchLoginPage(url);
	}

	
	
}
