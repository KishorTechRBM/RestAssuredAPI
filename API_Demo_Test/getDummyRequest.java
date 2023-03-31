package API_Demo_Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class getDummyRequest {
	Response response = get("http://localhost:3000/users");
	JSONObject request = new JSONObject();

	@BeforeTest
	public void beforeTest() {
		baseURI = "http://localhost:3000";
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
//		System.out.println(response.getBody().asString()); // we can use .asString only as well.
		
		int statusCode = response.getStatusCode();		
		Assert.assertEquals(statusCode, 200);
	}

	@Test
	public void testGetAPI() {		
				given()
					.contentType("application/json")
			    .when()
					.get("/users")
				.then()
					.statusCode(200)
				    .body("data[0].firstName", equalTo("Raman"));
			
	}

}
