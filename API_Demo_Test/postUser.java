package API_Demo_Test;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class postUser extends RestUtils {
	public static HashMap map = new HashMap();
	
	@BeforeTest
	public void postData() {
		Response response = get("https://reqres.in/api/users");
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="api/users";
		
//		map.put("name",RestUtils.getName());
//		map.put("job",RestUtils.getJob());
		
//		Map<String, Object>map = new HashMap<String, Object>();
//		map.put("name","Kishor");
//		map.put("job","QA");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Kishor_POST");
		request.put("job", "QA_POST");
		System.out.println(response.getBody().asString()); // we can use .asString only as well.
		
		
		
	}
	
	@Test
	public void testPost() {
		String name1=getName();
		given()
				.contentType("application/json; charset=utf-8")
//				.body(map)
		
		.when()
				.post()
		.then()
				.statusCode(201);
//				.and()
//				.body("name",equalTo(name1))
//				.and()
//				.body("job", equalTo("leader"));
	}

}
