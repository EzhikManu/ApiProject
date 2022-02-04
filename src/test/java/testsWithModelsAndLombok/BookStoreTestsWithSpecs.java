package testsWithModelsAndLombok;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static testsWithModelsAndLombok.Specs.BookStoreSpec.request;
import static testsWithModelsAndLombok.Specs.BookStoreSpec.responseSpec;

public class BookStoreTestsWithSpecs extends TestBase {
    String requestURL = "https://demoqa.com/Account/v1/GenerateToken";

    @Test
    void generateTokenTest() {
        given()
                .spec(request)
                .when()
                .post(requestURL)
                .then()
                .spec(responseSpec)
                .log().all();
    }

    @Test
    void generateTokenWithSchemaAndPrettyAllure() {
        given()
                .spec(request)
                .when()
                .post(requestURL)
                .then()
                .spec(responseSpec)
                .body(matchesJsonSchemaInClasspath("schemas/generateTokenSchema.json"))
                .log().all();
    }
}
