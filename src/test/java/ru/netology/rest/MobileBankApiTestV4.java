package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.RestAssured.given;

class MobileBankApiTestV4 {
    @Test
    void shouldReturnDemoAccounts() {
        given()
                .baseUri("http://localhost:9999/api/v1")
                .when()
                .get("/demo/accounts")
                .then()
                .statusCode(200)
                // 2. Проверка соответствия ответа схеме
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
    }
}
