import config.JokesConfig;
import config.JokesEndpoints;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import objects.Joke;
import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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

        jokeOfTheDay.then().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("JokesSchema.json"));

        Joke joke = jokeOfTheDay.getBody().as(Joke.class);

        try {
            String fileName = JokesEndpoints.FILE_PATH + String.format("%s.txt", jokeOfTheDay.jsonPath().get("id").toString());
            File file = new File(fileName);
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            pw.print(joke.toString());
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
