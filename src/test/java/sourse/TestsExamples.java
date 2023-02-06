package sourse;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;


public class TestsExamples{
	
//	@Test
	public void testGet() {
		
		baseURI = "http://localhost:3000";
		
		// information about second user
		
		given().
			get("/users/2").
		then().statusCode(200).log().all();
	}
	
	
	
//	@Test
	public void testPost() {
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		
		request.put("firstName", "Tom");
		request.put("lastName", "Pit");
		request.put("password","Tpit$$$");
		request.put("user_id",9093);
		request.put("platform_id",1111);
		request.put("login","Tpit232");
		request.put("country_id", 375);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users").
		then().statusCode(201);
		
		
	}
	
	// if want for example change platform id 1111 to 1112 for the user we just posted
	
	@Test
	public void testPatch() {
		baseURI = "http://localhost:3000";

		JSONObject request = new JSONObject();
		
		request.put("platform_id", 1112);
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			patch("users/5"). 
		then().statusCode(200).log().all();
	}	

}
