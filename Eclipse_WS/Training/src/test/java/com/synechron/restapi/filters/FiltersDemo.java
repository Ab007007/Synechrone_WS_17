package com.synechron.restapi.filters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.StringWriter;

import org.apache.commons.io.output.WriterOutputStream;
import org.hamcrest.CoreMatchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;

public class FiltersDemo {
	
	
	public static StringWriter requestWriter;
	public static PrintStream requestCapture;
	
	public static StringWriter responseWriter;
	public static PrintStream responseCapture;
	
	@BeforeMethod
	public void setup() {
		
		requestWriter = new StringWriter();
		requestCapture = new PrintStream(new WriterOutputStream(requestWriter),true);
		
		responseWriter = new StringWriter();
		responseCapture = new PrintStream(new WriterOutputStream(responseWriter),true);
	}

	
	//@Test
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
	public void logWithFilter() throws IOException {
		RestAssured.baseURI = "https://api.trello.com";
		RestAssured.
		given().
			param("key", "c5f676759b86029624f7dcb31ccf655e")
			.param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
			filter(new RequestLoggingFilter(requestCapture)).
			filter(new ResponseLoggingFilter(responseCapture)).
		when()
			.get("/1/boards/OIyIpjvA").
		then().assertThat().statusCode(200)
			.body("id", CoreMatchers.equalTo("62847c77dd28b963065a845b"))
			.body("name", CoreMatchers.equalTo("MyAPIBoard"));

		System.out.println("--test complets---" + requestWriter.toString());
		String fileName = new Faker().name().firstName();
		System.out.println("Name : "  + fileName);
		File f = new File("log/log_"+ fileName + ".txt");
		if(!f.exists())
			f.createNewFile();		
		
		FileWriter fw  = new FileWriter(f);
		fw.write(requestWriter.toString());
		System.out.println("############################################################");
		System.out.println("--test complets---" + responseWriter.toString());
		fw.write("###################################################################");
		fw.write(responseWriter.toString());
		fw.flush();
	}
}
