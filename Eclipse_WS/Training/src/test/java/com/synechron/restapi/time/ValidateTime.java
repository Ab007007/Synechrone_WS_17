package com.synechron.restapi.time;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.rootPath;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.synechron.restapi.post.RepositoryVariables;

import static io.restassured.RestAssured.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ValidateTime {

	public static RequestSpecBuilder builder; 
	public static RequestSpecification rspec;
	
	public static ResponseSpecBuilder resBuilder;
	public static ResponseSpecification resSpec;
	public static String repoName = "MYTEstRepo1234";
	
	@BeforeClass
	public void getSpecObject() {
		baseURI = "https://api.github.com";
		
		builder = new RequestSpecBuilder();
		builder.addHeader("Content-Type", "application/json");
		builder.addHeader("Authorization", "Bearer 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");
		rspec = builder.build();
		
		resBuilder = new ResponseSpecBuilder();
		resBuilder.expectHeader("Server", "GitHub.com");
		//resBuilder.expectHeader("Content-Type", "application/json; charset=utf-8");
		
		resSpec = resBuilder.build();
		
	}
	
	@Test
	public void validateTimeInMS() {
		long time = given().
			spec(rspec).
		when().
			get("/users/Ab007007/repos").time();
		System.out.println("Total Response time : "  + time);

	}
	@Test
	public void validateTimeInSec() {
		long time = given().
			spec(rspec).
		when().
			get("/repositories").timeIn(TimeUnit.SECONDS);
		System.out.println("Total Response time in Sec : "  + time);

	}
	
	
	
}
