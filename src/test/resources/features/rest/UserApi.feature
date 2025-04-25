@RestTest

Feature: User API


Scenario: Create a new user
Given the following user data:
| Field       |  Value         |
| name   |  morpheus      |
| job    |  Leader        |
 When the user sends a POST request to "/api/users"
 Then the response status should be 201
 And the response should contain the name "morpheus" and job "Leader"
 And the response should contain an id and createdAt timestamp
 

 Scenario: Successfully retrieve a user based on the userId
 Given the user ID is "2"
 When the user sends a GET request to "/api/users/{id}"
 Then the response status should be 200
 And the response should contain the following:
 |	id				 |		2											|
 |	email			 |	janet.weaver@reqres.in	|
 | first_name  |  Janet      |
 | last_name   |  Weaver        |
 |	avatar			| https://reqres.in/img/faces/2-image.jpg |
 
  
 Scenario: Get List of Users
  When the user sends a GET request to "/api/users?page=1"
  Then the response status should be 200
  And the response should contain a list of users
  
  
  Scenario: Get non existing user
  Given the user ID is "23"
 	When the user sends a GET request to "/api/users/{id}"
 	Then the response status should be 404
 	
 
 	Scenario: Update a user information
 	Given the user ID is "2"
 	And the following user data:
 	| Field       |    Value		|
 	| name				| 	neo				|
 	|	job					|	IT Engineer	|
 	When the user sends a PUT request to "/api/users/{id}"
 	Then the response status should be 200
 	And the response should contain the name "neo" and job "IT Engineer" and createdAt timestamp
 
 
Scenario: Update a user with PATCH
 	Given the user ID is "1"
 	And the following user data:
 	| Field       |    Value		|
 	|	job					|	QA Engineer	|
 	When the user sends a PATCH request to "/api/users/{id}"
 	Then the response status should be 200
 	And the response should contain the job "QA Engineer" and createdAt timestamp
 	
 	
 	Scenario: Delete a valid user
 	Given the user ID is "3"
 	When the user sends a DELETE request to "/api/users/{id}"
 	Then the response status should be 204 