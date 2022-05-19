package com.synechron.restapi.get;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetDemo {

	@Test
	public void simpleBDDFormat() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.given().param("key", "c5f676759b86029624f7dcb31ccf655e")
				.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").when()
				.get("/1/boards/OIyIpjvA").then().assertThat().statusCode(200)
				.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
				.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---");
	}

	@Test
	public void RestAssuredFormat() {

		RequestSpecification reqSpe = RestAssured.given();

		reqSpe.param("key", "c5f676759b86029624f7dcb31ccf655e");
		reqSpe.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");

		Response res = reqSpe.get("https://api.trello.com/1/boards/OIyIpjvA");

		res.prettyPrint();
		res.then().statusCode(200);
		res.then().body("name", CoreMatchers.equalTo("MyAPIBoard"));
		System.out.println("done");
	}

	@Test
	public void GivenExpectFormat() {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.given().param("key", "c5f676759b86029624f7dcb31ccf655e")
				.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").expect()
				.statusCode(200).and().body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b")).and()
				.body("name", CoreMatchers.equalTo("MyAPIBoard")).when().get("/1/boards/OIyIpjvA");
		System.out.println("--test complets---");
	}
}
