package api.qa.com.tests;

import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import api.qa.com.pojo.POJOClass;
import api.qa.com.util.ReadTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class post_BDD_APITest {
	
	//Using BDD Approach
	
	// 1. By using the entire json in an external file.
	@Test
	public void PostAutomation_Test() throws IOException, ParseException {
		
    File file = new File("/Users/aajaykumardinne/eclipse-workspace/APIAutomation_RestAssured_Framework_SDET/resources/Testdata/postMethodRequestBody.json");	
		
	FileInputStream fip = new FileInputStream(file); 
		
	Response response =  given().log().all()
						 .contentType(ContentType.JSON)
						.body(org.apache.commons.io.IOUtils.toString(fip, "UTF-8"))
						.when()
						.post(ReadTestData.getTestData("POSTURI"));
	
	System.out.println("API Status Code: " + response.getStatusCode());
	
	assertEquals(response.getStatusCode(), 201);
	
	System.out.println(response.getBody().asString());
		
	}
	
	//2. By using POJO class. prefered method for Automation
	
	@Test
	public void post_POJOTest() throws IOException, ParseException {
		
			POJOClass poj = new POJOClass("merpheus", "leader");
		
			List<String> jobslists = new ArrayList<String>();
			jobslists.add("tester");
			jobslists.add("developer");
			jobslists.add("support");
			
			poj.setJobs(jobslists);
				
			Response response =  given().log().all()
								 .contentType(ContentType.JSON)
								.body(poj)
								.when()
								.post(ReadTestData.getTestData("POSTURI"));
			
			System.out.println("API Status Code: " + response.getStatusCode());
			
			assertEquals(response.getStatusCode(), 201);
			
			System.out.println(response.getBody().asString());
	}

}
