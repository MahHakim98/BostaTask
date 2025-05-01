package bosta.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ForgetPasswordTest {

    @Test
    public void forgetPassword() {
        // Corrected request body
        String requestBody = "{\n" +
                "  \"email\": \"firstname.lastname@bosta.co\",\n" + // Valid email format
                "  \"password\": \"<script>alert('XSS in Password')</script>\"\n" + // XSS Injection attempt
                "}";

        RestAssured
                .given()
                .baseUri("https://stg-app.bosta.co")
                .basePath("/api/v2/users/forget-password")
                .contentType(ContentType.JSON)
                .body(requestBody)  // Corrected body with SQL and XSS injections
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200); // Expecting a successful response with 200 OK
    }

}