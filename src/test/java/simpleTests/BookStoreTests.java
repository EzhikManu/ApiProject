package simpleTests;

import io.qameta.allure.restassured.AllureRestAssured;
import org.junit.jupiter.api.Test;
import testsWithModelsAndLombok.TestBase;

import java.util.HashMap;
import java.util.Map;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;

public class BookStoreTests extends TestBase {
    String requestURL = "https://demoqa.com/Account/v1/GenerateToken";
    static Map<String, String> generateData() {
        Map<String, String> data = new HashMap<>();
        data.put("userName", "alex");
        data.put("password", "asdsad#frew_DFS2");
        return data;
    }

    @Test
    void generateTokenWithSchemaAndPrettyAllure() {
        given()
                .filter(customLogFilter().withCustomTemplates())
                .contentType("application/json")
                .body(generateData())
                .when()
                .post(requestURL)
                .then()
                .log().ifError()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("schemas/generateTokenSchema.json"))
                .body("status", is("Success"))
                .body("token", is(notNullValue()));
    }
}
