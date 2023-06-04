package api.qa.com.tests;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import api.qa.com.pojo.POJOClass;
import api.qa.com.util.ReadTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class put_BDD_APITest {
	
	
	@Test
	public void patch_POJOTest() throws IOException, ParseException {
		
			POJOClass poj = new POJOClass("merpheus", "zion resident");
				
			Response response =  given().log().all()
								 .contentType(ContentType.JSON)
								.body(poj)
								.when()
								.put(ReadTestData.getTestData("PATCHURI"));
			
			System.out.println("API Status Code: " + response.getStatusCode());
			
			assertEquals(response.getStatusCode(), 200);
			
			System.out.println(response.getBody().asString());
	}

}
