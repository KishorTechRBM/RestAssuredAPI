package API_Demo_Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class jsonSchemaValidator {
	
	@Test
	public void get() {
		baseURI = "https://reqres.in/api";

		given()
			.contentType("application/json; charset=utf-8")
		.when()
			.get("/users?page=2")
		.then()
			.assertThat().body(matchesJsonSchemaInClasspath("schema.json"))
			.statusCode(200)
			.body("data[4].first_name", equalTo("George"))
			.log().all();
	}

}
