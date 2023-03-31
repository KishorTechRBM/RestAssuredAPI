package API_Demo_Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class postDummyRequest {
	JSONObject request = new JSONObject();

	@BeforeTest
	public void beforeTest() {
		baseURI = "http://localhost:3000";
	}
	
	@Test
	public void testPostAPI() {				
		request.put("firstname", "Sourav");
		request.put("lastname", "Singh");
		request.put("subjectId", 2);

		given()
			.contentType("application/json; charset=utf-8")
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
	}


}
