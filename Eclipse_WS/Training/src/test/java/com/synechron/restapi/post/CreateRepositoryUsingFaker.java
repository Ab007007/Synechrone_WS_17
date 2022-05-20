package com.synechron.restapi.post;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;

public class CreateRepositoryUsingFaker {
	
	@Test
	public void createRepository() {
		RestAssured.baseURI = "https://api.github.com";
		
		RepositoryVariables repo = new RepositoryVariables();
		Faker f = new Faker();
		
		repo.setName("myPOJORepo" + f.name().firstName());
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
