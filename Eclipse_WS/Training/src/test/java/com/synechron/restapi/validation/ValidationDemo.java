package com.synechron.restapi.validation;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ValidationDemo {

	
	@Test
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
		
		String jsonResponse = response.asString();
		
		String id = JsonPath.read(jsonResponse, "$.id");
		String name = JsonPath.read(jsonResponse, "$.name");
		
		// write a code to print all width
		//$.prefs.backgroundImageScaled[*].width
		List<Integer> widths = JsonPath.read(jsonResponse, "$..width");
		for (Integer width : widths) 
		{
			System.out.println(width);
			
		}
		
		
		List<String> urls = JsonPath.read(jsonResponse,"$..url");
		for (String url : urls) {
			System.out.println(url);
		}
				
		System.out.println("____________________________________________________");
		List<Integer> widthsWithLimit = JsonPath.read(jsonResponse, "$.prefs.backgroundImageScaled.[?(@.width<1300)].width");
		for (Integer width : widthsWithLimit) 
		{
			System.out.println(width);
			
		}
		
		
		
		
		
		System.out.println("ID : "  + id);
		System.out.println("NAME : " + name);
		System.out.println("--test complets---");
	}
}
