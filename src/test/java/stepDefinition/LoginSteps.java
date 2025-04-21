package stepDefinition;

import static org.assertj.core.api.Assertions.assertThat;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utility.BrowserDriver;


public class LoginSteps {
	
	LoginPage loginPage = new LoginPage();
	
	@Given("the user is on the login page {string}")
	public void the_user_is_on_the_login_page(String url) {
		 
	   loginPage.launchLoginPage(url);
	}

	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String username, String password) {
	   loginPage.enterUsername(username);
	   loginPage.enterPassword(password);
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	   loginPage.clickButton();
	}

	@Then("the user should see the error message {string}")
	public void the_user_should_see_the_error_message(String string) {
	   verifyLoginMessage(string);
	   BrowserDriver.quitDriver(); 
	}

	@Then("the user should land on the products page and see the title {string}")
	public void the_user_should_land_on_the_products_page_and_see_the_title(String string) {
		verifyLoginMessage(string);
		BrowserDriver.quitDriver(); 
	}
	
	private void verifyLoginMessage(String expectedMessage) {
		assertThat(loginPage.verifyMessage(expectedMessage)).as("Expected message not found: %s", expectedMessage)
				.isTrue();
		
	}

}
