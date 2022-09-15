package put_request;



import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

    public class Put_13 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/updateAccount
Request Method: PUT
Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss),
 birth_date, birth_month, birth_year, firstname, lastname, company, address1,
 address2, country, zipcode, state, city, mobile_number
Response Code: 200
Response Message: User updated!
     */

        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "updateAccount");

            Map<String, String > dataMap = new HashMap<>();
            dataMap.put("name", "mahmut");
            dataMap.put("email", "mahmut@gmail.com");
            dataMap.put("password", "1234");
            dataMap.put("title", "Mr");
            dataMap.put("birth_day", "12");
            dataMap.put("birth_month", "3");
            dataMap.put("mobile_number", "2355");
            dataMap.put("birth_year", "2000");
            dataMap.put("firstname", "mahmut");
            dataMap.put("lastname", "Al");
            dataMap.put("address1", "mahm");
            dataMap.put("address2", "hm");
            dataMap.put("country", "ABV");
            dataMap.put("state", "qwe");
            dataMap.put("city", "KLM");
            dataMap.put("zipcode", "875");
            dataMap.put("company", "com");

            System.out.println(dataMap);

            Response response = given().spec(spec).formParams(dataMap).when().put("/{first}/{second}");

            response.jsonPath().prettyPrint();

            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("User updated!", actualData.getString("message"));
            Assert.assertEquals("200", actualData.getString("responseCode"));
        }

    }


