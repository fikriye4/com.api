package post_request;


import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

    public class Post_06 extends AutomationExercise {


    /*
    API URL: https://automationexercise.com/api/searchProduct
Request Method: POST
Response Code: 400
Response Message: Bad request, search_product parameter is missing in POST request.
     */


        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "searchProduct");


            Response response = given().spec(spec).contentType(ContentType.JSON).when().post("/{first}/{second}");

            response.jsonPath().prettyPrint();

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("Bad request, search_product parameter is missing in POST request.", actualData.getString("message"));
            Assert.assertEquals("400", actualData.getString("responseCode"));

        }
    }

