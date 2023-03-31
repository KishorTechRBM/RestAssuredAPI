package API_Demo_Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class patchDummyRequest {
	JSONObject request = new JSONObject();

	@BeforeTest
	public void beforeTest() {
		baseURI = "http://localhost:3000";
	}
	
	@Test
	public void testPutAPI() {
		request.put("firstname", "Kishor_Patch1");

		given()
			.contentType("application/json; charset=utf-8")
		.when()
			.put("/users/6")
		.then()
			.statusCode(200);
	}

}
