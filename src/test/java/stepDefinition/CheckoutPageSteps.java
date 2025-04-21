package stepDefinition;

import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ProductPage;
import utility.BrowserDriver;
import utility.CommonStepsUtil;

public class CheckoutPageSteps {

	LoginPage loginPage = new LoginPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	ProductPage productPage = new ProductPage();

	@Given("User has clicked on the checkout button")
	public void user_has_clicked_on_the_checkout_button() throws InterruptedException {
		loginPage.launchLoginPage("https://www.saucedemo.com/");
		loginPage.enterUsername("standard_user");
		loginPage.enterPassword("secret_sauce");
		loginPage.clickButton();
		productPage.clickAddToCartButton();
		productPage.goToCart();
		BrowserDriver.clickButton("#checkout");
	}

	@Given("the user is on checkout information page")
	public void the_user_is_on_checkout_information_page() {
		productPage.verifySubTitle("Checkout: Your Information");
	}

	@When("the user fills in the below information")
	public void the_user_fills_in_the_below_information(DataTable dataTable) {
		checkoutPage.fillCheckoutForm(dataTable);
		
	}

	@When("clicks on {string} button")
	public void clicks_on_button(String string) {
		BrowserDriver.clickButton("#continue");
		
	}
	
	@When("finally clicks on finish button")
	public void finally_clicks_on_finish_button() {
		BrowserDriver.clickButton("#continue");
		BrowserDriver.clickButton("#finish");
	}

	@Then("the user should receive an error message {string}")
	public void the_user_should_receive_an_error_message(String expectedMessage) {
		assertThat(checkoutPage.isErrorMessageDisplayed(expectedMessage))
        .as("Expected error message not displayed: " + expectedMessage)
        .isTrue();
    BrowserDriver.quitDriver();
}

	@Then("the user should see the {string} message")
	public void the_user_should_see_the_message(String expectedMessage) {
	    String actualMessage = checkoutPage.getConfirmationMessage();
	    assertThat(actualMessage)
	        .as("Expected confirmation message not displayed.")
	        .isEqualTo(expectedMessage);
	    BrowserDriver.quitDriver();
	}
	
	//@When("the user clicks on {string} button")
	//public void the_user_clicks_on_button(String buttonName) {
	  //  CommonStepsUtil.clickButtonByName(buttonName);
	  
	//}
	

	
}
