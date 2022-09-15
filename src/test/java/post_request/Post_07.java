package post_request;

import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class Post_07 extends AutomationExercise {
    /*
    API 7: POST To Verify Login with valid details
     API URL: https://automationexercise.com/api/verifyLogin
     Request Method: POST
     Request Parameters: email, password
     Response Code: 200
     Response Message: User exists!*/
    @Test
    public void test01(){

        spec.pathParams("first", "api", "second", "verifyLogin");



        Response response = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}/{second}");

        response.jsonPath().prettyPrint();
        JsonPath actualData = response.jsonPath();


        Assert.assertEquals("Response Message ", actualData.getString("User exists!"));
        Assert.assertEquals("200", actualData.getString("responseCode"));



    }
}