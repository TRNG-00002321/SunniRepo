package com.revature.ra;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;

public class DemoRestAssured01Test {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @AfterAll
    static void teardown() {
        RestAssured.reset();
    }

    @Test
    public void firstRequestDemo() {
        given()
                .log().all()
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .statusCode(200);

    }

    @Test
    public void testWithMoreDetails() {
        given()
                .log().parameters()
                .queryParam("userId", 1)
                .when().get("/posts") // post?userId=1
                .then()
                .log().all()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("size()", greaterThan(0));

    }

    //Write a method to test     "https://jsonplaceholder.typicode.com/users/1";
    // Tests 
    // name = Leaanne Graham
    // email contains @
    // city = Gwenbourough
    // lat = #
    @Test
    public void testUser() {
        given()
                .log().all()
                .when()
                .get("users/1")
                .then()
                .statusCode(200)
                .body("name", equalTo("Leanne Graham"))
                .body("email", containsString("@"))
                .body("address.city", equalTo("Gwenborough"))
                .body("address.geo.lat", equalTo("-37.3159"));
    }
}
