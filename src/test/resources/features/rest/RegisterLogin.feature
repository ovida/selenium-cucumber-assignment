Feature: Register and Login API

Scenario: Register user - Successful
Given the below credentials
| Field  		|  Value							|
| email			| eve.holt@reqres.in	|
| password	| test							|
When the user sends a POST request to "/api/register"
Then the response status should be 200
And the id and token is returned

Scenario: Register using missing password
Given the below credentials
| Field  		|  Value							|
| email			| sydney@fife					|
When the user sends a POST request to "/api/register"
Then the response status should be 400
And the response should contain error "Missing password"

Scenario: Login user with invalid credentials
Given the below credentials
| Field  		|  Value							|
| email			| test@gmail.com	|
| password	| test							|
When the user sends a POST request to "/api/login"
Then the response status should be 400
And the response should contain error "user not found"