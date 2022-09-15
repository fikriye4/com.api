package base_url;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

    public class AutomationExercise {

        public RequestSpecification spec;

        @Before
        public void setUp(){

            spec =new RequestSpecBuilder().setBaseUri("https://www.automationexercise.com").build();
        }
    }


