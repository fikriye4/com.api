package delete_request;


    import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

    public class Delete_12 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/deleteAccount
Request Method: DELETE
Request Parameters: email, password
Response Code: 200
Response Message: Account deleted!
     */

        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "deleteAccount");

            Map<String,String > data=new HashMap<>();
            data.put("email","mahmut@gmail.com");
            data.put("password","1234");

            Response response = given().spec(spec).formParams(data).when().delete("/{first}/{second}");

            response.jsonPath().prettyPrint();

            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("Account deleted!", actualData.getString("message"));
            Assert.assertEquals("200", actualData.getString("responseCode"));



        }



    }


