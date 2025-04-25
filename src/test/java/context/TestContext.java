package context;

import java.util.Map;

import io.restassured.response.Response;

public class TestContext {

private Map<String, String> userData;
	
	private Response response;

	public Map<String, String> getUserData() {
		return userData;
	}

	public void setUserData(Map<String, String> userData) {
		this.userData = userData;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
	}
}
