package post_request;



import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class Post_08 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/verifyLogin
Request Method: POST
Request Parameter: password
Response Code: 400
Response Message: Bad request, email or password parameter is missing in POST request.
     */

        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "verifyLogin");

            Response response = given().spec(spec).formParams("password","123456789").when().post("/{first}/{second}");

            response.jsonPath().prettyPrint();

            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("Bad request, email or password parameter is missing in POST request.", actualData.getString("message"));
            Assert.assertEquals("400", actualData.getString("responseCode"));



        }
    }


