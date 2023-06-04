package api.qa.com.tests;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.qa.com.mi.commonMethodsTest;
import api.qa.com.util.ReadTestData;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.IOException;

public class get_BDD_APITest {
	
	
	// using BDD Approach
	
	@Test(description = "validates the status codes for GET users Endpoint")
	public void verifyStatusCodesTest() throws IOException, ParseException {
		
		
	 System.out.println("*****  " + ReadTestData.getTestData("URIGetUsers"));
	 
	 Response response = 	given()
			 				.when().log().all()
			 				.get(ReadTestData.getTestData("URIGetUsers"));
		
	 int statusCode = response.getStatusCode();
	  
	 //prints the status code on the console
	 System.out.println("API status code: " + statusCode);
	 
	 Assert.assertEquals(statusCode, 200);
	 
	 String  actualEmailValue = response.path("data[1].email");
	 
	 System.out.println("*****  " + ReadTestData.getTestData("ExpectedEmailValue"));
	 Assert.assertEquals(actualEmailValue, ReadTestData.getTestData("ExpectedEmailValue"));
	 	
	}
	
	
	@Test(description = "validates the Response with Multiple Query Parameters for the GET Request")
	public void validateResponsebody_Multiple_QueryParametersTest() throws IOException, ParseException {
			
	Response response	= 	given()
			.queryParam("page", 2)
			.queryParam("test", 2)
			.log().all()
			.when().get(commonMethodsTest.getURI());
	
	 int statusCode = response.getStatusCode();
	 
	 System.out.println("API status code: " + statusCode);
	 
	 Assert.assertEquals(statusCode, 200);
	 
	 String responseBody =  response.body().asString();
	 
	 System.out.println("API Response body: " + responseBody);
	 
	 int actualTotalValue = response.path("total");
	 
	 System.out.println("Total value: " + actualTotalValue);
	 
	 Assert.assertEquals(actualTotalValue, 12);
	 
			
	}
	
	
	@Test(description = "validates the Response with Multiple Headers for the GET Request")
	public void validateResponsebody_get_Multiple_HeadersTest() {
		
		Response response = given()
		.headers("Content-type","application/json")
		.headers("Connection", "keep-alive")
		.log().all()
		.when()
		.get("https://gorest.co.in/public-api/users");
		
		 int statusCode = response.getStatusCode();
		 
		 System.out.println("API status code: " + statusCode);
		 
		 Assert.assertEquals(statusCode, 200);
		 
		 System.out.println(response.body().asString());
		
	}
	
	
	@Test
	public void validateResponsebody_pathParam_Test() {
		
	Response response = given()
						.log()
						.all()
						.pathParam("raceSeason", 2020)
						.when()
						.get("http://ergast.com/api/f1/{raceSeason}/circuits.json");
	
	 int statusCode = response.getStatusCode();
	 
	 System.out.println("API status code: " + statusCode);
	 
	 Assert.assertEquals(statusCode, 200);
	 
	 System.out.println(response.body().asString());
		
	}

}
