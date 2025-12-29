package com.revature.api;

import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.notNullValue;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class JSONPlaceholderApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    @Order(1)
    @DisplayName("GET /posts should return 200 and list of posts")
    public void getAllPost() {
        when()
                .get("/posts")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("[0].id", equalTo(1));
    }

    @Test
    @Order(2)
    @DisplayName("GET /posts/1 should return specific post")
    public void testGetPostById() {
        given()
                .pathParam("id", 1)
                .when()
                .get("/posts/{id}")
                .then()
                .statusCode(200)
                .contentType("application/json")
                .body("id", equalTo(1))
                .body("title", not(emptyString()))
                .body("body", not(emptyString()))
                .body("userId", equalTo(1));
    }

    @Test
    @Order(3)
    @DisplayName("GET /posts?id=1 should retrn specific post")
    public void testGetPostByQueryParams() {
        given()
                .queryParam("id", 1)
                .when()
                .get("/posts")
                .then()
                .log().all()
                .statusCode(200)
                .contentType("application/json")
                .body("[0].id", equalTo(1))
                .body("[0].title", not(emptyString()))
                .body("[0].body", not(emptyString()))
                .body("[0].userId", equalTo(1));
    }

    @Test
    @Order(4)
    @DisplayName("POST /posts should create new post")
    public void testCreatePostWithString() {
        String methodBody = """
        {
            "title": "Title",
            "body": "Body",
            "userId": 1
        }
        """;
        given()
                .contentType("application/json")
                .body(methodBody)
                .when()
                .post("/posts")
                .then()
                .statusCode(201)
                .body("id", notNullValue())
                .body("title", equalTo("Title"))
                .body("userId", equalTo(1));

    }

    @Test
    @Order(5)
    @DisplayName("POST /post with map body")
    public void testCreatePostWithMap() {

    }
}
