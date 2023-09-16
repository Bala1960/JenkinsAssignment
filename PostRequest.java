import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;


public class PostRequest {
RequestSpecification requestspecification;
Response response;
ValidatableResponse validateresponse;
// https://dummy.restapiexample.com/api/v1/create"

@Test	
public void GetUpdateUser()
	{
	String jsonString = "{\"id\": 23,\r\n"
            + "        \"employee_name\": \"Mugil2022\",\r\n"
            + "        \"employee_salary\": 80000,\r\n"
            + "        \"employee_age\": 45,\r\n"
            + "        \"profile_image\": \"\"}";	
//String jsonString = "{\"name\":\"newapitest\",\"salary\":\"4000\",\"age\":\"29\"}";
	 

		// base URI
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1/create";
		// request specification
		requestspecification = RestAssured.given();
		// content type
		requestspecification.contentType(ContentType.JSON);
		// body of the json string
		requestspecification.body(jsonString);
		// call the post method
		response=requestspecification.request(Method.POST,"");
		// print the response body
		System.out.println(response.asPrettyString());
		//validate the response
		validateresponse=response.then();
		// check the status code
		validateresponse.statusCode(200);
		// check if the status is through HTTP
		validateresponse.statusLine("HTTP/1.1 200 OK");
		// get the respone name and body
		validateresponse.body("data.employee_name", equalTo("Mugil2022"));
		// get the message attribute of the response
		validateresponse.body("message", equalTo("Successfully created"));
		
	}
}
