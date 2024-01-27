package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.BeforeClass;


public class JokesConfig {
    @BeforeClass
    public static void setup(){
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri(JokesEndpoints.JOKES_URL)
                .addHeader("x-rapidapi-host",JokesEndpoints.HOST )
                .addHeader("x-rapidapi-key", JokesEndpoints.KEY)
                .addFilter(new RequestLoggingFilter()) //for personal use
                .addFilter(new ResponseLoggingFilter()) //for personal use
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}
