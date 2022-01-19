package testsWithModelsAndLombok.Specs;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static filters.CustomLogFilter.customLogFilter;
import static io.restassured.RestAssured.with;

public class ReqresSpec {
    public static RequestSpecification reqresRequest = with()
            .filter(customLogFilter().withCustomTemplates())
            .contentType(ContentType.JSON);
}
