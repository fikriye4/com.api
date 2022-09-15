package get_request;
import base_url.AutomationExercise;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

    public class Get_01 extends AutomationExercise{

/*
API URL: https://automationexercise.com/api/productsList
Request Method: GET
Response Code: 200
Response JSON: All products list
 */


        @Test
        public void test01(){

            //  AutomationExercise auto=new AutomationExercise();

            spec.pathParams("first","api","second","productsList");


            Response response=given().spec(spec).when().get("/{first}/{second}");


            response.jsonPath().prettyPrint();



            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            System.out.println(actualData.getString(""));






        }
    }

