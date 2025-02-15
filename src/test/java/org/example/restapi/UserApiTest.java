package org.example.restapi;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class UserApiTest {

    @BeforeAll
    public static void setup() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testCreateUser() {
     given()
             .queryParam("name", "Mimi")
             .when()
             .post("/users")
             .then()
             .statusCode(200)
        .body(equalTo("user created Mimi"));
    }

    @Test
    public void testGetAllUsers(){
        when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Mimi"));
    }

    @Test
    public void testUpdateUser(){
        given()
                .queryParam( "name", "Kiki")
                .when()
                .put("/users/10")
                .then()
                .statusCode(200)
                .body(equalTo("user updated Kiki"));
    }

    @Test
    public void testGetAllUsersAfterUpdate(){
        when()
        .get("/users")
                .then()
                .statusCode(200)
                .body("[1].name", equalTo("Kiki"));
    }

    @Test
    public void testDeleteUser(){
        when()
                .delete("/users/10")
                .then()
                .statusCode(200)
                .body(equalTo("user deleted Kiki"));
    }
}
