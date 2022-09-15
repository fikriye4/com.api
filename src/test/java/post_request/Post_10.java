package post_request;


import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class Post_10 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/verifyLogin
Request Method: POST
Request Parameters: email, password (invalid values)
Response Code: 404
Response Message: User not found!
     */

        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "verifyLogin");

            Response response = given().spec(spec).formParams("email","ali@gmail.com","password","16789").when().post("/{first}/{second}");

            response.jsonPath().prettyPrint();

            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("User not found!", actualData.getString("message"));
            Assert.assertEquals("404", actualData.getString("responseCode"));



        }
    }


