package com.synechron.restapi.specification;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.synechron.restapi.post.RepositoryVariables;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class RequestSpecificationDemo {

	public static RequestSpecBuilder builder; 
	public static RequestSpecification rspec;
	
	public static ResponseSpecBuilder resBuilder;
	public static ResponseSpecification resSpec;
	public static String repoName = "MYTEstRepo1234";
	
	@BeforeClass
	public void getSpecObject() {
		RestAssured.baseURI = "https://api.github.com";
		
		builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", "application/json");
		builder.addHeader("Authorization", "Bearer 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");
		rspec = builder.build();
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeader("Server", "GitHub.com");
		//resBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		
		resSpec = resBuilder.build();
		
	}
	
	
	@Test(priority = 1)
	public void createRepository() {
		RepositoryVariables repo = new RepositoryVariables();
		
		repo.setName(repoName);
		repo.setDescription("asdfasdfasfdasdfasFD");
		RestAssured.
		given().
			spec(rspec).
			body(repo).
		when(). 
			post("/user/repos").
		then().
			spec(resSpec).
			assertThat().statusCode(201);
			
	}
	
	@Test(priority = 2)
	public void getRepository() {
		RestAssured.
		given().
			spec(rspec).
		when().
			get("/users/Ab007007/repos").
		then().
			spec(resSpec).
			assertThat().statusCode(200);
	}
	
	
	@Test(priority = 3)
	public void deleteRepo()
	{
		RestAssured.
		given().
			spec(rspec).
		when().
			delete("/repos/Ab007007/" + repoName).
		then().
			spec(resSpec).
			assertThat().statusCode(204);
		System.out.println("deleted successfully");
			
	
	}
}
