package com.synechron.restapi.log;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class LogDemo {

	
	
	@Test
	public void logHeaders() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().log().headers().
			param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when()
			.get("/1/boards/OIyIpjvA").
		then().assertThat().statusCode(200)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---");
	}
	
	
	@Test
	public void logAllRequest() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().log().all().
			param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when()
			.get("/1/boards/OIyIpjvA").
		then().assertThat().statusCode(200)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---");
	}
	
	
	@Test
	public void logAllRequestAndResponse() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().log().all().
			param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when()
			.get("/1/boards/OIyIpjvA").
		then().log().all().assertThat().statusCode(201)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---");
	}
	
	
	@Test
	public void logAllRequestAndResponseIfValidationFailed() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().log().all().
			param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when()
			.get("/1/boards/OIyIpjvA").
		then().log().ifValidationFails().assertThat().statusCode(201)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---");
	}
}
