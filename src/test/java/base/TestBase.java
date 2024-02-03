package base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected static final String BASE_URL = "https://jsonplaceholder.typicode.com";
    protected static final String POSTS_ENDPOINT = BASE_URL + "/posts";
    // Define other endpoints here if necessary

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = BASE_URL;
    }
}

//Info on  JSONPlaceholder, which is a free fake online REST API designed for 
//testing and prototyping.