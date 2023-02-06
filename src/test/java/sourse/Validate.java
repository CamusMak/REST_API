package sourse;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import org.testng.annotations.Test;


// this class contains three test methods to check response against schema validation

public class Validate {
	
	@Test
	public void validate_users() {
		baseURI = "http://localhost:3000";
		
		given().get("/users").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
		
	}
	
	@Test
	public void validate_platform() {
		baseURI = "http://localhost:3000";
		
		given().get("/platform").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
		
		
	}
	
	@Test
	public void validate_country() {
		baseURI = "http://localhost:3000";
		
		given().get("/country").then().assertThat().body(matchesJsonSchemaInClasspath("schema.json")).
		statusCode(200);
		
	}

}
