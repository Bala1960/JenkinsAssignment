import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.CoreMatchers.equalTo;
//https://reqres.in/api/users
//	id": 1,
//    "email": "george.bluth@reqres.in",
//    "first_name": "George",
//    "last_name": "Bluth",
//    "avatar": "https://reqres.in/img/faces/1-image.jpg"
//  },

public class PutMethod {
	
	RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
	
@Test	
	public void UpdateUser()
	{
	String jsonString = "{\"id\": 21,\r\n"
            + "        \"employee_name\": \"Mugil2022\",\r\n"
            + "        \"employee_salary\": 80000,\r\n"
            + "        \"employee_age\": 45,\r\n"
            + "        \"profile_image\": \"\"}";

RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/update/21";

// Create a request specification
requestSpecification = RestAssured.given();

// Setting content type to specify format in which request payload will be sent.
requestSpecification.contentType(ContentType.JSON);

// Adding body as string
requestSpecification.body(jsonString);

// Calling PUT method
response = requestSpecification.request(Method.PUT," ");;

// Let's print response body.
System.out.println(response.prettyPrint());

validatableResponse = response.then();
// Get status code
validatableResponse.statusCode(200);
// It will check if status line is as expected
validatableResponse.statusLine("HTTP/1.1 200 OK");
// Check response - name attribute
validatableResponse.body("data.employee_salary", equalTo(80000));
// Check response - message attribute
validatableResponse.body("message", equalTo("Successfully! Record has been updated."));

}
}
