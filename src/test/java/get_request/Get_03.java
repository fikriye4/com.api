package get_request;


import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class Get_03 extends AutomationExercise {


    /*
    API URL: https://automationexercise.com/api/brandsList
Request Method: GET
Response Code: 200
Response JSON: All brands list
     */

        @Test
        public void test01(){


            spec.pathParams("first","api","second","brandsList");


            Response response=given().spec(spec).accept(ContentType.JSON).when().get("/{first}/{second}");

            response.then().assertThat().statusCode(200);

            response.jsonPath().prettyPrint();




        }


    }


