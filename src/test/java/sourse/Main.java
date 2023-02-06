package sourse;


/* In this project I am trying to create a simple REST API.
 	This project is MAVEN project. Dependicies in pom.xml comes from MAVEN
 	central repository. I used node.js to create json-server for my API.
 	thsi is the first command I used in command line to install json-server
 	>> npm install -g json-server
 	then the following to start a json-server
 	>> json-server --watch api.json 
 	where api is my file name;
 	
 	in the bellow code there are three class for different types of data I want to transfer via
 	REST API.
 	User class  for general information about users
 	Platform class  for platform information
 	Country class for country information
 	
 	to post data I used post function from REST_API class in this package
 	
 	In In Validate class I did validation test to check if response corresponse to the schema
 	of api.json file. I converted api.json to schema.json(schema file) on 
 	https://www.liquid-technologies.com free converter webbsite.

*/
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Main{
	
	public static void main(String[] args) {
		
		User user_1 = new User("John","Brow","Jbrown","jbrown1999",9089,
								1112,374);
		User user_2 = new User("Lucka","Bond","Lbond","lbond",9090,
								1111,375);
		User user_3 = new User("Bob","Marley","Bmarley","bmarley##",9091,
								1112,374);
		User user_4 = new User("David","Bin","Dbind","dbind#$$",9092,
								1111,376);
		
		Platform  ios = new Platform(1112,"ios");
		Platform android = new Platform(1111,"android");
		
		Country country_1 = new Country(374,"ARM","Armenia");
		Country country_2 = new Country(375,"US","United States");
		Country country_3 = new Country(376,"RUS","Russia");

		

		
//		REST_API.post_user(user_1);
//		REST_API.post_user(user_2);
//		REST_API.post_user(user_3);
//		REST_API.post_user(user_4);
//		
//		REST_API.post_platform(ios);
//		REST_API.post_platform(android);
////		
//		REST_API.post_country(country_1);
//		REST_API.post_country(country_2);
//		REST_API.post_country(country_3);
		
		REST_API.delete("users", 1);
		
	}
}



class User{
	
	private String firstName, lastName, password, login;
	
	private int user_id,platform_id ,countryId;
	
	User(String firstName, String lastName,String password, 
			String login, int user_id,int platform_id, int countryId){
		this.firstName = firstName;
		this.lastName = lastName;
		this.platform_id = platform_id;
		this.user_id = user_id; 
		this.password = password;
		this.login = login;
		this.countryId = countryId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getFullName() {
		return this.firstName + " " + this.lastName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public int getUserId() {
		return this.user_id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getLogin() {
		return this.login;
	}
	
	
	public int getPlatformId() {
		return this.platform_id;
	}
	
	
	public int getCountryId() {
		return this.countryId;
	}
	
	public String toString() {
		return "firstName: " + this.firstName + "\nlastName: " + 
				this.lastName + ",\nlogin: " + this.login +
				"\npassword: " + this.password + "\nuserId: " +
				this.user_id + "\nplatfomr_id: " + this.platform_id +
				"\ncountry_id: " + this.countryId;				
	}
}

class Platform{
	
	private int platoformId;
	private String platformName;
	
		
	Platform(int platformId, String platoformName){
		this.platoformId = platformId;
		this.platformName = platoformName;
	}
	
	public int getPlatofrmId() {
		return this.platoformId;
	}
	
	public String getPlatformName() {
		return this.platformName;
	}
	
}

class Country{
	
	private int  country_id;
	private String  country_name, country_code;
	
	Country(int country_id, String country_code,String country_name){
		
		this.country_id = country_id;
		this.country_code = country_code;
		this.country_name = country_name;

	}
	
	
	
	public int getCountryId() {
		return this.country_id;
	}
	
	
	public String getCountryName() {
		return this.country_name;
	}
	
	public String getCountryCode() {
		return this.country_code;
	}
	
	
}