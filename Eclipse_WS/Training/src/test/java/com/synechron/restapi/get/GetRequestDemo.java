package com.synechron.restapi.get;

import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;

public class GetRequestDemo {

	
	public static void main(String[] args) 
	{
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given(). 
			param("key", "c5f676759b86029624f7dcb31ccf655e").
			param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
		when().
			get("/1/boards/OIyIpjvA").
		then().
			assertThat().statusCode(200)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		
		System.out.println("--test complets---");
		
	}
}
