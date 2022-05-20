package com.synechron.restapi.validation;

import java.util.Map;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class JsonPathDemo {

	
	//@Test
	public void simpleBDDFormat() {
		RestAssured.baseURI = "https://api.trello.com";
		Response response = RestAssured.
				given().
					param("key", "c5f676759b86029624f7dcb31ccf655e").
					param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				when().
					get("/1/boards/OZdccU3E").then().assertThat().statusCode(200)
						.body("id", CoreMatchers.equalTo("621361a123899b38145e5225")).
				extract().response();
		
		String resString = response.asString();
		
		JsonPath responseBody = new JsonPath(resString);
		
		
		System.out.println("ID " + responseBody.get("id"));
		System.out.println("Name  " + responseBody.get("name"));
		
		System.out.println("--test complets---");
	}
	
	@Test
	public void validatableResponseDemo() {
		RestAssured.baseURI = "https://api.trello.com";
		 ValidatableResponse vResponse = RestAssured.
				given().
					param("key", "c5f676759b86029624f7dcb31ccf655e").
					param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				when().
					get("/1/boards/OZdccU3E").
				then().assertThat().statusCode(200)
						.body("id", CoreMatchers.equalTo("621361a123899b38145e5225"));
		
		
		
		
		System.out.println("ID " + vResponse.extract().path("id"));
		System.out.println("Name " + vResponse.extract().path("name"));
		
		//find a node whose width is 140
		Map<String,String> node = vResponse.extract().path("prefs.backgroundImageScaled.find { it.width == 140 }");
		System.out.println("NODE WITH WIDTH 140 : " + node.toString());
		
		//find a url whose width is 140
		String url = vResponse.extract().path("prefs.backgroundImageScaled.find { it.width == 140 }.url");
				
		System.out.println("URL  : " + url.toString());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("--test complets---");
	}
}
