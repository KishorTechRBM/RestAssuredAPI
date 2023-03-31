package API_Demo_Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteDummyRequest {
	JSONObject request = new JSONObject();

	@BeforeTest
	public void beforeTest() {
		baseURI = "http://localhost:3000";
	}
	
	@Test
	public void testDeleteAPI() {
		
		given()
		.contentType("application/json; charset=utf-8")
		.when()
			.delete("/users/5")
		.then()
			.statusCode(200);
	}


}
