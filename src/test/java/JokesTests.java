import config.JokesConfig;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.get;

public class JokesTests extends JokesConfig {
    @Test
    public void test1() {
        get("test")
                .then()
                .statusCode(200);
    }

    @Test
    public void test2() {
        List<String> categories =   get("categories").path("categories");

    }
}
