package com.synechron.restapi.staticimports;

import java.util.List;
import org.testng.annotations.Test;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

public class StaticImportsDemo {


	@Test
	public void simpleBDDFormat() {
		baseURI = "https://api.trello.com";
		Response response = 
				given().
					param("key", "c5f676759b86029624f7dcb31ccf655e").
					param("token", "9b60bd7325defc221aa0203822765f426ecb134adcf46f7ca823c569ced3a2f3").
				when().
					get("/1/boards/OZdccU3E").
				then().assertThat().statusCode(200)
						.body("id", equalTo("621361a123899b38145e5225")).
				extract().
					response();
		
		String jsonResponse = response.asString();
	}
}
