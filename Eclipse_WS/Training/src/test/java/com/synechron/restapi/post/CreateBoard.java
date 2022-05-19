package com.synechron.restapi.post;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateBoard {
	
	@Test
	public void createBoard() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given(). 
			queryParam("key", "c5f676759b86029624f7dcb31ccf655e").
			queryParam("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			queryParam("name", "AutomationBoardFromEclipse").
			headers("Content-Type","application/json").
		when().
			post("/1/boards").
		then().
			assertThat().statusCode(200);
	
		
		System.out.println("--test complets---");
	}

}
