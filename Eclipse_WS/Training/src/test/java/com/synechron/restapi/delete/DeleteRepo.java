package com.synechron.restapi.delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteRepo {

	
	@Test
	public void deleteRepo()
	{
		RestAssured.baseURI = "https://api.github.com";
		
		RestAssured.
		given().
			headers("Content-Type","application/json").
			headers("Authorization","Bearer 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").
		when().
			delete("/repos/Ab007007/myPOJORepo").
		then().
			assertThat().statusCode(204);
		
		System.out.println("deleted successfully");
			
	
	}
}
