package restObjects;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestApiObject {
	
	public static String getBaseUri() {
		return "https://reqres.in";
	}

	
	public static Response sendRequestWithBody(String method, String endpoint, String payload) {
		RequestSpecification request = given()
				.log().all()
				.baseUri(getBaseUri())
				.header("Content-Type", "application/json")
				.body(payload);

		switch (method.toUpperCase()) {
			case "POST":
				return request.post(endpoint);
			case "PATCH":
				return request.patch(endpoint);
			case "PUT":
				return request.put(endpoint);
			case "DELETE":
				return request.delete(endpoint);
			default:
				throw new IllegalArgumentException("Unsupported method: " + method);
		}
	}
	
	

	public static Response sendRequestWithoutBody(String method, String resolvedEndpoint) {
		RequestSpecification request = given()
				.log().all()
				.baseUri(getBaseUri())
				.header("Content-Type", "application/json");
		
				
		
		switch (method.toUpperCase()) {
			case "GET":
				return request.get(resolvedEndpoint);
			case "DELETE":
				return request.delete(resolvedEndpoint);
			default:
				throw new IllegalArgumentException("Unsupported method: " + method);
		}
	}
	
	
	public static Map<String, Object> getDataMapFromResponse(Response response) {
		return response.jsonPath().getMap("data");
	}
	
	public static Map<String, Object> expectedUserData(int id, String email, String firstName, String lastName, String avatar) {
		return Map.of("id", id, "email", email, "first_name", firstName, "last_name", lastName, "avatar", avatar);
	}

	public static String getCreateUserPayload(String name, String job) {
		return "{\n" + "  \"name\": \"" + name + "\",\n" + "  \"job\": \"" + job + "\"\n" + "}";
	}
	
	public static String updateUserPayload(String job) {
		return "{\n" + "  \"job\": \"" + job + "\"\n" + "}";
	}
	
	public static String getRegisterPayload(String email, String password) {
	    return "{ \"email\": \"" + email + "\", \"password\": \"" + password + "\" }";
	}
	public static String getRegisterPayload(String email) {
	    return "{ \"email\": \"" + email + "\"}";
	}

}
