package API_Demo_Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class putDummyRequest {
	JSONObject request = new JSONObject();

	@BeforeTest
	public void beforeTest() {
		baseURI = "http://localhost:3000";
	}
	
	@Test
	public void testPutAPI() {
		request.put("firstname", "Raman");
		request.put("subjectId", "1");
		request.put("lastname", "Sharma");

		given()
			.contentType("application/json; charset=utf-8")
		.when()
			.put("/users/5")
		.then()
			.statusCode(200);
	}

}
