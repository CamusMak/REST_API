package sourse;

import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class REST_API {
	
	public static void post_user(User user) {
		
		// this the base uri of my computer local host server
		baseURI = "http://localhost:3000";
		
		JSONObject request = new JSONObject();
		
		request.put("login", user.getLogin());
		request.put("firstName",user.getFirstName());
		request.put("lastName", user.getLastName());
		request.put("password",user.getPassword());
		request.put("user_id", user.getUserId());
		request.put("platform_id", user.getPlatformId());
		request.put("country_id", user.getCountryId());
		
		given().
			contentType(ContentType.JSON).
			accept(ContentType.JSON).
			body(request.toJSONString()).
		when().
			post("/users");
	}
	
	public static void post_country(Country country) {
			
		
			baseURI = "http://localhost:3000";
			
			JSONObject request = new JSONObject();
			
			request.put("country_id", country.getCountryId());
			request.put("country_code", country.getCountryCode());
			request.put("country_name", country.getCountryName());
			
			
			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				post("/country");
		}
	
	
	
	public static void post_platform(Platform platform) {
			
			baseURI = "http://localhost:3000";
			
			JSONObject request = new JSONObject();
					
			request.put("id", platform.getPlatofrmId());
			request.put("name", platform.getPlatformName());
			
			given().get("/platform").then().body("id",hasItems(1112,1111)).log().all();

			given().
				contentType(ContentType.JSON).
				accept(ContentType.JSON).
				body(request.toJSONString()).
			when().
				post("/platform");
		}
	
	public static void delete(String sourse,int id) {
		
		baseURI = "http://localhost:3000";
		
		
		given().delete("/"+sourse+"/"+Integer.toString(id));
		

	}

}
