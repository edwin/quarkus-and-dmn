package com.edw;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class ValidationTest {

    @Test
    public void testAge15AndSalary100_loanLimit5000() {
        given()
                .body("{ \"age\": 15, \"salary\": 100 }")
                .contentType(ContentType.JSON)
                .when()
                .post("/Validation")
                .then()
                .statusCode(200)
                .body("'loan_limit'", is(5000));
    }

    @Test
    public void testAge21AndSalary100_loanLimit10000() {
        given()
                .body("{ \"age\": 21, \"salary\": 100 }")
                .contentType(ContentType.JSON)
                .when()
                .post("/Validation")
                .then()
                .statusCode(200)
                .body("'loan_limit'", is(10000));
    }

    @Test
    public void testAge100AndSalary1000_loanLimit25000() {
        given()
                .body("{ \"age\": 100, \"salary\": 1000 }")
                .contentType(ContentType.JSON)
                .when()
                .post("/Validation")
                .then()
                .statusCode(200)
                .body("'loan_limit'", is(25000));
    }

    @Test
    public void testAge100AndSalary2000_loanLimit30000() {
        given()
                .body("{ \"age\": 100, \"salary\": 2000 }")
                .contentType(ContentType.JSON)
                .when()
                .post("/Validation")
                .then()
                .statusCode(200)
                .body("'loan_limit'", is(30000));
    }

    @Test
    public void testAge45AndSalary1000_loanLimit10000() {
        given()
                .body("{ \"age\": 45, \"salary\": 1000 }")
                .contentType(ContentType.JSON)
                .when()
                .post("/Validation")
                .then()
                .statusCode(200)
                .body("'loan_limit'", is(10000));
    }
}
