package stepDefinition.rest;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class RegisterLoginSteps {

	private final TestContext context;

	public RegisterLoginSteps(TestContext context) {
		this.context = context;
    }
	
	@Given("the below credentials")
	public void the_below_credentials(DataTable dataTable) {
	   
		context.setUserData(dataTable.asMap(String.class, String.class));
	}

	@Then("the id and token is returned")
	public void the_id_and_token_is_returned() {
		String id = context.getResponse().jsonPath().getString("id");
		String token = context.getResponse().jsonPath().getString("token");
		assert id != null && !id.isEmpty() : "ID is not present in the response";
		assert token != null && !token.isEmpty() : "Token is not present in the response";
		System.out.println("ID: " + id + " Token: " + token);
	}

	@Then("the response should contain error {string}")
	public void the_response_should_contain_error(String errorMessage) {
		String responseError = context.getResponse().jsonPath().getString("error");
		assert errorMessage.equals(responseError)
				: "Expected error message: " + errorMessage + ", but got: " + responseError;
		//System.out.println("Error message: " + errorMessage);
	}
}
