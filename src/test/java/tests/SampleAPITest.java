package tests;

import base.TestBase;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class SampleAPITest extends TestBase {

    @Test
    public void getPostsTest() {
        given()
            .when()
                .get(POSTS_ENDPOINT)
            .then()
                .assertThat()
                .statusCode(200)
                .body("size()", greaterThan(0));
    }

    @Test
    public void getSinglePostTest() {
        int postId = 1;
        given()
            .when()
                .get(POSTS_ENDPOINT + "/" + postId)
            .then()
                .assertThat()
                .statusCode(200)
                .body("id", equalTo(postId));
    }

    @Test
    public void createPostTest() {
        given()
            .contentType("application/json")
            .body("{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}")
            .when()
                .post(POSTS_ENDPOINT)
            .then()
                .assertThat()
                .statusCode(201)
                .body("title", equalTo("foo"))
                .body("body", equalTo("bar"))
                .body("userId", equalTo(1));
    }

    @Test
    public void updatePostTest() {
        int postId = 1;
        given()
            .contentType("application/json")
            .body("{\"id\": " + postId + ", \"title\": \"updated title\", \"body\": \"updated body\", \"userId\": 1}")
            .when()
                .put(POSTS_ENDPOINT + "/" + postId)
            .then()
                .assertThat()
                .statusCode(200)
                .body("title", equalTo("updated title"))
                .body("body", equalTo("updated body"))
                .body("userId", equalTo(1));
    }

    @Test
    public void deletePostTest() {
        int postId = 1;
        given()
            .when()
                .delete(POSTS_ENDPOINT + "/" + postId)
            .then()
                .assertThat()
                .statusCode(200);
    }
}
