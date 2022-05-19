package com.synechron.restapi.post;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateRepositoryUsingPOJO {
	
	@Test
	public void createRepository() {
		RestAssured.baseURI = "https://api.github.com";
		
		RepositoryVariables repo = new RepositoryVariables();
		repo.setName("myPOJORepo");
		repo.setDescription("asdfasdfasfdasdfasFD");
		
		RestAssured.
		given().
			headers("Content-Type","application/json").
			headers("Authorization","Bearer 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").
			body(repo). 
		when(). 
			post("/user/repos").
		then().
			assertThat().statusCode(201);
			
	}

}
