package API_Demo_Test;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

/*
given()
set cookies, add auth, add param, set headers info etc....

when()
get, post, put, delete…

then ()
validate status code, extract response, extract headers cookies & response body....
*/

public class getWeatherRequest {

	@Test
	public void getWeatherRequest() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK");
//			.assertThat().body("first_name",equalTo("Michael"))
//			.header("Content-Type","applocation/json");

	}
}
