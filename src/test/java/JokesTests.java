import config.JokesConfig;
import config.JokesEndpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import objects.Joke;
import org.junit.Test;

import java.io.*;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.lessThan;

public class JokesTests extends JokesConfig {
    @Test
    public void test1() {
        get("test")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .time(lessThan(3000L));
    }

    @Test
    public void test2() {

        Response categories = get("categories")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .time(lessThan(3000L))
                .extract().response();

        String category = categories.path("categories[2]");

        Response jokeOfTheDay = get("joke/" + category);

        //Validating the joke properties (sometimes the API response is missing required properties like 'delivery' and 'setup,' and replacing them with 'joke')
        jokeOfTheDay.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JokesSchema.json"));

        Joke joke = jokeOfTheDay.getBody().as(Joke.class);

        try {
            String fileName = JokesEndpoints.FILE_PATH + String.format("%s.txt", jokeOfTheDay.jsonPath().get("id").toString());
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(joke.toString());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
