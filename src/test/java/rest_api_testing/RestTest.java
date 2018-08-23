package rest_api_testing;
import static org.testng.Assert.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.* ;

import static org.hamcrest.Matchers.* ;



public class RestTest {

	
	
	
	@BeforeClass
	public void setUp() {
		RestAssured.baseURI="https://www.api-batch8.dev.cc/wp-json";
		basePath="/wp/v2";
	}
	
	
	
	//Given rets end point http://73.166.37.2:1000/ords/hr/employees/
	//When I send http GET request to the server
	//Then I should get 200 ok result as status code
	@Test
	public void firstTest() {
		
		when()
		.get("http://73.166.37.2:1000/ords/hr/employees/")
		.then()
		.statusCode(200) ;
		
	}
	
	
	//Given rets end point http://73.166.37.2:1000/ords/hr/jobs/
		//When I send http GET request to the server
		//Then I should get 200 ok result as status code
	
	
	@Test
	
	public void secondTest() {
		when()
		.get("http://73.166.37.2:1000/ords/hr/jobs/")
		.then()
		.statusCode(200);
	}
	
	
	
	//Given rest end point https://www.api-batch8.dev.cc/wp-json/wp/v2/posts
	//When I send http GET request to the server
	//Then I should get 200 ok result as status code
	
@Test
	
	public void thirdTest() {
		
	given().relaxedHTTPSValidation()
	.when()
	.get(" https://www.api-batch8.dev.cc/wp-json/wp/v2/posts")
	.then()
	.statusCode(200);    }
	
	



//Given rest end point //Given rest end point https://www.api-batch8.dev.cc/wp-json/wp/v2/posts/22
//When I send http GET request to the server
//Then I should get 200 ok result as status code
//And id field should be 22
	
@Test

public void postIdTest() {
	given().relaxedHTTPSValidation()
	.when()
	.get("https://www.api-batch8.dev.cc/wp-json/wp/v2/posts/22")
	.then()
	.statusCode(200)
	.and()
	.body("id", equalTo(22))
	.body("title.rendered",equalTo("my awesome title again") );
	
}



@Test

public void idTestwithLogDetail() {
	given().relaxedHTTPSValidation()
	.when()
	.log().all()
	.get("/posts/22")
	.then()
	.log().all()
	.statusCode(200)
	.and()
	.body("id", equalTo(22))
	.body("title.rendered",equalTo("my awesome title again") );
	
}



@Test

public void fifthTest() {
	given().relaxedHTTPSValidation()
	.log().all()
	.when()
	.get("https://www.api-batch8.dev.cc/wp-json/wp/v2/posts/{id}", 22)
	.then()
	.statusCode(200)
	.body("id", equalTo(22))
	.body("title.rendered",equalTo("my awesome title again") );
	
	
	}


@Test

public void testwithHamcrest() {
	int a=5, b=5, c=6;
	
	assertTrue(a==c);
}






	
}
