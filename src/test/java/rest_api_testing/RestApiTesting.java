package rest_api_testing;

import static io.restassured.RestAssured.basePath;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.* ;
import static org.hamcrest.Matchers.* ;

public class RestApiTesting {
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://www.api-batch8.dev.cc/wp-json";
		basePath="/wp/v2";
	}
	@Test
	public  void simpleGetRequestforSingleItem() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		//.queryParam("per_page", 2)
		.get("/posts/{id}",15)
		.then()
		.log().all()
		.assertThat()
		.statusCode(200)
		.and()
		.body("id", equalTo(110000) );
		/*.body("title.rendered", is("posting using rest service by aysel"))
		.body("sticky", is(false));*/
		
	}
	
	
	@Test 
	public void printBody() {
		given()
		.relaxedHTTPSValidation()
		.when()
		.log().all()
		.pathParam("value", 36)
		//.queryParam("per_page", 2)
		.get("/posts/{value}")
		.body().prettyPrint();
	}
	
	//how to post requets ( create new post)
	@Test
	public void simplePostTest() {
		given().relaxedHTTPSValidation()
		.when()
		.auth().preemptive()
		.basic("aysel92", "23B09A1990b1992a")
		.contentType(ContentType.JSON)
		.when()
		.body("{\n" + 
				"    \"title\":\"HOW TO PASS INTERVIEW\" ,\n" + 
				"    \"content\": \"amazing content\",\n" + 
				"    \"status\" : \"publish\"\n" + 
				"\n" + 
				"}")
		.log().all()
		.post("/posts")
		.then()
		.statusCode(201);
		
}
	
	//how to put request( change title)
	
	@Test
	public void simplePutTest() {
		given().relaxedHTTPSValidation()
		.when()
		.auth().preemptive()
		.basic("aysel92", "23B09A1990b1992a")
		.contentType(ContentType.JSON)
		.when()
		.body("{\n" + 
				"    \"title\":\"HOW TO PASS INTERVIEW :)\" ,\n" + 
				"    \"content\": \"amazing content\",\n" + 
				"    \"status\" : \"publish\"\n" + 
				"\n" + 
				"}")
		.log().all()
		.pathParam("newID", 36)
		.put("/posts/{newID}")
		.then()
		.log().all()
		.statusCode(200)
		.body("title.rendered", is("HOW TO PASS INTERVIEW :)"));
		
}
	
	//HOW TO DELETE POST
	
	@Test
	
	public void deletePostTest() {
		
			given().relaxedHTTPSValidation()
			.when()
			.auth().preemptive()
			.basic("aysel92", "23B09A1990b1992a")
			.when()
			.pathParam("deleteId", 15)
			.queryParam("force", true)
			.delete("/posts/{deleteId}")
			.then()
			.statusCode(200)
			.body("deleted", is(true));
	}
	
}
