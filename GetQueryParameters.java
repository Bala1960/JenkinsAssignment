import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetQueryParameters {
	@Test
	public void filterParameter()
	{
		RestAssured.baseURI = "https://reqres.in/api";
        Response response=null;
        try {
        	response = RestAssured.given()
	       .when().queryParam("Page","2").queryParam("id",5)
	       .get("/users");
        } catch(Exception e){
        	e.printStackTrace();
        	
        }
       System.out.println(response.asString());
       System.out.println(response.getStatusCode());
	}
	@Test
	public void sampleTest() {
	    RestAssured.given()
	     .contentType("application/json")
	     .queryParam("type", "owner")
	     .when()
	     .get("https://api.github.com/users/steveJobs")
	     .then()
	     .statusCode(200);
	}
	@Test
	public void getRepos() {
	    RestAssured.given()
	    .when()
	    .get("https://api.github.com/users/SteveJobs/repos1")
	    .then().statusCode(200);
	}
	@Test
	public void createRepo() {
		String token = "a45288ceeb72c5aca8a79aa9405471c07c4e785b";
		RestAssured.given()
		.header("authorization", "bearer " + token)
		.body("{\"name\" : \"RestAssured\"}")
		.when()
		.post("https://api.github.com/user/repos")
		.then()
		.statusCode(201);
	}
	}
	    
	

