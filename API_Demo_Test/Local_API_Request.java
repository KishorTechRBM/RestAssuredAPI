package API_Demo_Test;


import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;   //to organise imports keys are ctrl+shift+O

import io.restassured.http.ContentType;

public class Local_API_Request {

//	@Test
	public void get() {
		baseURI = "http://localhost:3000";

		given()
			.contentType("application/json; charset=utf-8")
		.when()
			.get("/users")
		.then()
			.statusCode(200)
			.log().all();
//			.body("firstname", equalTo("<[Kishor, Rajan, Rahul, Kayum]>"));
	}
	
//	@Test
	public void post() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Sourav");
		request.put("lastname", "Singh");
		request.put("subjectId", 2);
		
		baseURI = "http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.post("/users")
		.then()
			.statusCode(201);
	}
	
//	@Test
	public void put() {
		JSONObject request = new JSONObject();
		request.put("firstname", "Sourav1");
		request.put("lastname", "Singh1");
		request.put("subjectId", 1);
		
		baseURI = "http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.put("/users/5")
		.then()
			.statusCode(200);
	}
	
//	@Test
	public void patch() {
		JSONObject request = new JSONObject();
		request.put("lastname", "Pal");
		
		baseURI = "http://localhost:3000";

		given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
		.when()
			.patch("/users/5")
		.then()
			.statusCode(200);
	}
	
	@Test
	public void testDeleteAPI() {
		baseURI = "http://localhost:3000";
		
		when()
			.delete("/users/5")
		.then()
			.statusCode(200);
	}

}
