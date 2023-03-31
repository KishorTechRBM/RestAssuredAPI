package API_Demo_Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class patchRequest {
	@BeforeTest
	public void postData() {
		JSONObject request = new JSONObject();
		request.put("name", "Kishor");
		request.put("job", "QA");

		baseURI = "https://reqres.in/";
		basePath = "api/users/2";
		
//		RestAssured.baseURI="https://reqres.in/";
//		RestAssured.basePath="api/users";			We can use these too.
	}

	@Test
	public void testPatch() {
		given()
			.contentType("application/json; charset=utf-8")
		.when()
//			.put("https://reqres.in/api/users/2")
			.patch()
		.then()
			.statusCode(200);
	}

}
