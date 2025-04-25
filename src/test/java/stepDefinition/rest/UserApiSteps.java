package stepDefinition.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import context.TestContext;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import restObjects.RestApiObject;

public class UserApiSteps {

	private final TestContext context;

	public UserApiSteps(TestContext context) {
		this.context = context;
    }
	
	private String userId;
	
	
	@Given("the following user data:")
	public void the_following_user_data(DataTable dataTable) {
	    
		context.setUserData(dataTable.asMap(String.class, String.class));
	}

	@When("the user sends a POST request to {string}")
		public void the_user_sends_a_post_request_to(String endpoint) {
			sendRequestWithUserData("POST", endpoint);
	}

	@Then("the response status should be {int}")
		public void the_response_status_should_be(Integer expectedStatusCode) {
		//System.out.println("Expected Status Code: " + context.getResponse().getStatusCode());
		context.getResponse().then().statusCode(expectedStatusCode);
	
	}
	
	@Then("the response should contain the name {string} and job {string}")
		public void the_response_should_contain_the_name_and_job(String expectedName, String expectedJob) {
		context.getResponse().then().body("name", equalTo(expectedName))	
				.body("job", equalTo(expectedJob));
			
	
	}

	@Then("the response should contain an id and createdAt timestamp")
	public void the_response_should_contain_an_id_and_created_at_timestamp() {
		String id = context.getResponse().jsonPath().getString("id");
		String createdAt = context.getResponse().jsonPath().getString("createdAt");
	   assert id != null && !id.isEmpty() : "ID is not present in the response";
	   //System.out.println("ID: " + id);
	}
	
	@Given("the user ID is {string}")
	public void the_user_id_is(String userId) {
		this.userId = userId;
	}

	@When("the user sends a GET request to {string}")
	public void the_user_sends_a_get_request_to(String endpoint) {
		String resolvedEndpoint = resolvedEndPoint(endpoint);
		Response response = RestApiObject.sendRequestWithoutBody("GET", resolvedEndpoint);
		context.setResponse(response);
	    //System.out.println("GET Response: " + response.asString());
	}

	@Then("the response should contain the user id {string}")
	public void the_response_should_contain_the_user_id(String expectedUserID) {
		 Integer actualUserId = context.getResponse().jsonPath().getInt("data.id");
		 assertEquals("User ID does not match", expectedUserID, actualUserId);
		 
		 
		
	}
	
	@Then("the response should contain the following:")
	public void the_response_should_contain_the_following(DataTable dataTable) {
		validateUserData(dataTable);
	}
	
	
	@Then("the response should contain a list of users")
	public void the_response_should_contain_a_list_of_users() {
	   List<?> users = context.getResponse().jsonPath().getList("data");
	   assert users != null && !users.isEmpty() : "User list is empty or null";
	   System.out.println("Users: " + users);
	}
	
	@When("the user sends a PUT request to {string}")
	public void the_user_sends_a_put_request_to(String endpoint) {
		String resolvedEndpoint = resolvedEndPoint(endpoint);
		sendRequestWithUserData("PUT", resolvedEndpoint);
	}
	
	@When("the user sends a PATCH request to {string}")
	public void the_user_sends_a_patch_request_to(String endpoint) {
		String resolvedEndpoint = resolvedEndPoint(endpoint);
		String payload = RestApiObject.updateUserPayload(context.getUserData().get("job"));
		Response response = RestApiObject.sendRequestWithBody("PATCH",resolvedEndpoint, payload);
		context.setResponse(response);
	}


	@Then("the response should contain the name {string} and job {string} and createdAt timestamp")
	public void the_response_should_contain_the_name_and_job_and_created_at_timestamp(String expectedName, String expectedJob) {
		context.getResponse().then().body("name", equalTo(context.getUserData().get("name")))
	   .body("job", equalTo(context.getUserData().get("job")))
	   .body("createdAt", equalTo(context.getUserData().get("createdAt")));
	}

	@Then("the response should contain the job {string} and createdAt timestamp")
	public void the_response_should_contain_the_job_and_created_at_timestamp(String expectedJob) {
		context.getResponse().then().body("job", equalTo(context.getUserData().get("job")))
	   .body("createdAt", equalTo(context.getUserData().get("createdAt")));
	}
	
	@When("the user sends a DELETE request to {string}")
	public void the_user_sends_a_delete_request_to(String endpoint) {
	   String resolvedEndpoint = resolvedEndPoint(endpoint);
	   Response response = RestApiObject.sendRequestWithoutBody("DELETE", resolvedEndpoint);
	   context.setResponse(response);
	}

	private String resolvedEndPoint(String endpoint) {
		return endpoint.contains("{id}") && userId != null
				? endpoint.replace("{id}", userId) : endpoint;
	}
	
	public void sendRequestWithUserData(String method, String endpoint) {
		Map<String, String> userData = context.getUserData();
		String payload;
		
		if(userData.containsKey("name") && userData.containsKey("job")) {
			payload = RestApiObject.getCreateUserPayload(userData.get("name"), userData.get("job"));
		}
		else if (userData.containsKey("email") && userData.containsKey("password")) {
			payload = RestApiObject.getRegisterPayload(userData.get("email"), userData.get("password"));
		} 
		else if (userData.containsKey("email")) {
			payload = RestApiObject.getRegisterPayload(userData.get("email"));
		}
		
		else {
			throw new IllegalArgumentException("Invalid user data provided");
		}
		
		context.setResponse(RestApiObject.sendRequestWithBody(method, endpoint, payload));
	}
	
	public void validateUserData(DataTable dataTable) {
		Map<String, Object> actualData = RestApiObject.getDataMapFromResponse(context.getResponse());
		Map<String, String> expectedData = dataTable.asMap(String.class, String.class);
		
		expectedData.forEach((key, expectedValue) -> {

			Object actualValue = actualData.get(key);
			assertNotNull("Field '"+ key  + "' is missising in response", actualValue);
			assertEquals(key + " does not match", expectedValue.toString(), actualValue.toString());
	
	    });
	}
}
