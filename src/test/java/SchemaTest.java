import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;


public class SchemaTest {

    @Test
    public void statusCode() {

        given()
                .baseUri("http://localhost:9999/api/v1/")
                .when()
                .get("demo/accounts")
                .then()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));


    }


    @Test
    public void headersSchemaJson() {

        given()
                .baseUri("http://json-schema.org/")
                .when()
                .get("/draft-07/schema")
                .then()
                .header("Content-Type", "application/schema+json");


    }

//    @Test
//    public void complianceDiagram() {
//
//        given()
//                .baseUri("http://json-schema.org/")
//                .when()
//                .get("/draft-07/schema")
//                .then()
//                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
//
//
//    }

//    @Test
//    public void complianceDiagramSchema() {
//
//        given()
//                .baseUri("http://json-schema.org/")
//                .when()
//                .get("/draft-07/schema")
//                .then()
//                .statusCode(200)
//                .body(matchesJsonSchemaInClasspath("accounts.schema.json"));
//
//
//    }


}
