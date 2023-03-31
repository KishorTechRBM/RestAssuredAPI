package API_Demo_Test;

import static io.restassured.RestAssured.basePath;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class deleteRequest {
	@BeforeTest
	public void postData() {
		baseURI = "https://reqres.in/";
		basePath = "api/users/2";
		
//		RestAssured.baseURI="https://reqres.in/";
//		RestAssured.basePath="api/users";			We can use these too.
	}

	@Test
	public void testDelete() {
		given()
			.contentType("application/json; charset=utf-8")
		.when()
//			.put("https://reqres.in/api/users/2")
			.delete()
		.then()
			.statusCode(204);
	}

}
