package api.qa.com.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class APIAuthentications_Test {
	
	//basic auth
	@Test
	public void basicAuth_Test() {
		
	Response response =  given()
						.auth()
						.basic("postman", "password")
						.log().all()
						.when()
						.get("https://postman-echo.com/basic-auth");
		
		 int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 String responseBody =  response.body().asString();
		 
		 System.out.println("API Response body: "  + responseBody);
			
	}
	
	//digest auth
	@Test
	public void digest_AuthTest() {
		
		Response response =  given()
				.auth()
				.digest("postman", "password")
				.log().all()
				.when()
				.get("https://postman-echo.com/basic-auth");
		
		int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 String responseBody =  response.body().asString();
		 
		 System.out.println("API Response body: "  + responseBody);

		
	}
	
	
	//OAuth1.0
	@Test
	public void OAuth1_Test(){
		
		Response response = 	given()
								.auth()
								.oauth("Consumer Key", "Consumer Secret", "AccessToken", "Token Secret")
								.when()
								.get("https://reqres.in/api/users/2");
		
		 int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 String responseBody =  response.body().asString();
		 
		 System.out.println("API Response body: "  + responseBody);
		
	}
	
	//OAuth2.0 -> mostly used authentication in real time api projects
	
	@Test
	public void OAuth2_Test() {
		
		Response response =	given()
							.auth()
							.oauth2("Access token")
							.when()
							.get("https://reqres.in/api/users/2");
		
		
		int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 String responseBody =  response.body().asString();
		 
		 System.out.println("API Response body: "  + responseBody);
		
		
	}
	
	
	//used for OAuth2.0 in real time projects
	@Test  
	public void OAuth2_Header_Test() {
	
		Response response =  given()
								.header("Authorization", "Access Token")
								.when()
								.get("https://reqres.in/api/users/2");
		
		int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 String responseBody =  response.body().asString();
		 
		 System.out.println("API Response body: "  + responseBody);
		
	}

}
