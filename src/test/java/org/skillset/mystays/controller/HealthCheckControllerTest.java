package org.skillset.mystays.controller;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class HealthCheckControllerTest {

    @Test
    void health() {
            given()
                    .when().get("/info/health")
                    .then()
                    .statusCode(200);
    }

    @Test
    void status() {
        given()
                .when().get("/info/status")
                .then()
                .statusCode(200);
    }
}