package com.synechron.restapi.get;

import org.hamcrest.CoreMatchers;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredGetFormat {

	
	public static void main(String[] args) {
		
		RequestSpecification reqSpe = RestAssured.given();
		
		reqSpe.param("key", "c5f676759b86029624f7dcb31ccf655e");
		reqSpe.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3");
		
		Response res = reqSpe.get("https://api.trello.com/1/boards/OIyIpjvA");
		
		res.prettyPrint();
		res.then().statusCode(200);
		res.then().body("name", CoreMatchers.equalTo("MyAPIBoard"));
		System.out.println("done");
	}
}
