package com.synechron.restapi.post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateRepository {
	
	@Test
	public void createRepository() {
		RestAssured.baseURI = "https://api.github.com";
		
		RestAssured.
		given().
			headers("Content-Type","application/json").
			headers("Authorization","Bearer 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").
			body("{\r\n" + 
					"    \"name\"  : \"Synechron_API_Eclipse_Generated_Repo\",\r\n" + 
					"    \"description\" : \"Test POST API in GITHUB\",\r\n" + 
					"    \"private\" : false\r\n" + 
					"}"). 
		when(). 
			post("/user/repos").
		then().
			assertThat().statusCode(201);
			
	}

}
