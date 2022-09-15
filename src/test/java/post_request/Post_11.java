package post_request;


import base_url.AutomationExercise;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

import static io.restassured.RestAssured.given;

    public class Post_11 extends AutomationExercise {

    /*
    API URL: https://automationexercise.com/api/createAccount
Request Method: POST
Request Parameters: name, email, password, title (for example: Mr, Mrs, Miss),
birth_date, birth_month, birth_year, firstname, lastname, company, address1,
address2, country, zipcode, state, city, mobile_number
Response Code: 201
Response Message: User created!
     */

        @Test
        public void test01() {

            spec.pathParams("first", "api", "second", "createAccount");

            Map<String, String > dataMap = new HashMap<>();
            dataMap.put("name", "kmileee");
            dataMap.put("email", "kmielee@gmail.com");
            dataMap.put("password", "1034");
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

            Response response = given().spec(spec).formParams(dataMap).when().post("/{first}/{second}");

            response.jsonPath().prettyPrint();

            response.then().assertThat().statusCode(200);

            JsonPath actualData = response.jsonPath();

            Assert.assertEquals("User created!", actualData.getString("message"));
            Assert.assertEquals("201", actualData.getString("responseCode"));
        }


    }

