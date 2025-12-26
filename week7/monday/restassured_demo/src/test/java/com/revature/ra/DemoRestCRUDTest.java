package com.revature.ra;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.number.OrderingComparison.lessThan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class DemoRestCRUDTest {

    static RequestSpecification requestSpec;
    static ResponseSpecification responseSpec;

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
        requestSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("X-Custom-Header", "RestAssuredDemo")
                .build();

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000L))
                .build();
    }

    @AfterAll
    static void teardown() {
        RestAssured.reset();
    }

    @Test
    @Order(1)
    public void getPost() {
        given()
                .spec(requestSpec)
                .when().get("posts/1")
                .then().spec(responseSpec)
                .statusCode(200);
    }

    @Test
    @Order(2)
    public void creatPostReturnsCreatedSource() {
        String requestBody = """
        {
            "title": "Test POST from rest assured",
            "body": "This post was created during our demo",
            "userId": 1
        }
                """;

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .extract()
                .response();

        int createdPostId = response.jsonPath().getInt("id");
        // System.out.println("Created post with Id: " + createdPostId);
    }

    @Test
    @DisplayName("CREATE - POST new post")
    void create_post_returnsCreatedResource() {
        // Request body as JSON string
        String requestBody = """
            {
                "title": "Test Post from REST Assured",
                "body": "This post was created during our demo",
                "userId": 1
            }
            """;

        Response response = given()
                .spec(requestSpec)
                .body(requestBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201) // Created
                .extract()
                .response();

        // Store ID for later tests
        int createdPostId = response.jsonPath().getInt("id");
        // System.out.println("Created post with ID: " + createdPostId);
    }

    @Test
    @DisplayName("Create Post with Java Object")
    public void testPostofSerialObject() {
        record Post(String title, String body, int userId) {

        }
        Post newPost = new Post("POJO Test", "Testing a POJO body", 1);

        Response response = given()
                .spec(requestSpec)
                .body(newPost)
                .when()
                .post("/posts")
                .then().statusCode(201)
                .body("title", equalTo("POJO Test"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();
    }

    @Test
    @DisplayName("PUT Post")
    public void testPut() {
        Post body = new Post("Replacement Title", "Replacement body", 1);

        Response response = given()
                .spec(requestSpec)
                .body(body)
                .when()
                .put("/posts/1")
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    @Test
    @DisplayName("DELETE Post")
    public void testDelete() {
        Post body = new Post("Post To Delete", "Body of post to delete", 1);

        given()
                .spec(requestSpec)
                .body(body)
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);

    }

    @ParameterizedTest(name = "Test GET /post/{0} returns 200")
    @ValueSource(ints = {1, 2, 3, 4, 5})
    public void testGetWithValueSource(int postId) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/posts/" + postId)
                .then().statusCode(200)
                .body("id", equalTo(postId))
                .extract()
                .response();
    }

    // Make call to user endpoint. Fetch name and make sure name matches the returned name using CsvSource
    @ParameterizedTest
    @CsvSource({
        "1, Leanne Graham",
        "2, Ervin Howell",
        "3, Clementine Bauch"
    })
    public void testGetUserNameWithCsv(int userId, String expectedName) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/users/" + userId)
                .then().statusCode(200)
                .body("name", equalTo(expectedName))
                .extract()
                .response();
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/users.csv", numLinesToSkip = 1)
    public void testGetUserNameWithCsvFile(int userId, String expectedName) {
        Response response = given()
                .spec(requestSpec)
                .when()
                .get("/users/" + userId)
                .then().statusCode(200)
                .body("name", equalTo(expectedName))
                .extract()
                .response();
    }

    @Test
    @DisplayName("Create Post with Java Object")
    public void testSerialObjectWithRecord() {
        record RecordPost(String title, String body, int userId) {

        }
        RecordPost newPost = new RecordPost("POJO Test", "Testing a POJO body", 1);

        Response response = given()
                .spec(requestSpec)
                .body(newPost)
                .when()
                .post("/posts")
                .then().statusCode(201)
                .body("title", equalTo("POJO Test"))
                .body("userId", equalTo(1))
                .body("id", notNullValue())
                .extract()
                .response();
    }
}
