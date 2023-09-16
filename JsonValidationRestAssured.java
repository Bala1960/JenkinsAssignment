import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonValidationRestAssured {
	
	
	
	@Test
	   public void validateJSONSchema(){

	//base URL
    RestAssured.baseURI = "https://jsonplaceholder.typicode.com/posts/2";

    //obtain response
    RestAssured.given()
    .when().get()

    //verify JSON Schema
    .then().assertThat()
    .body(JsonSchemaValidator.
    matchesJsonSchema(new File("src/test/resources/Schema.json")));
 }

}
