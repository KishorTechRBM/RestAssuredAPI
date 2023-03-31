package API_Demo_Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

//import io.restassured.RestAssured;   //RestAssured should removed from response line.


public class getRequest1 {
	
	@Test
	public void getUserDeatils() {
		Response response = get("https://reqres.in/api/users?page=2"); // after importing import static io.restassured.RestAssured.*; there is no need of RestAssured.
		//for this you need to add "static" and "*" in above import class and 
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		System.out.println(response.getContentType());
//		System.out.println(response.getBody().asString()); // we can use .asString only as well.
		
		int statusCode = response.getStatusCode();		
		Assert.assertEquals(statusCode, 200);
	}
	
	@Test
	public void testUserDetails() {
		given()
		.when()
			.get("https://reqres.in/api/users?page=2")
		.then()
			.statusCode(200)
			.body("data[1].first_name", equalTo("Lindsay"))
			.body("data[1].id", equalTo(8));
	}

}
