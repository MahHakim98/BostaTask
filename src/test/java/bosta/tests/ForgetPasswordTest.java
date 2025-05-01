package bosta.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class ForgetPasswordTest {

    @Test
    public void forgetPassword() {

        String requestBody = "{\n" +
                "  \"email\": \"firstname.lastname@bosta.co\",\n" +
                "  \"password\": \"<script>alert('XSS in Password')</script>\"\n" + // XSS Injection attempt
                "}";

        RestAssured
                .given()
                .baseUri("https://stg-app.bosta.co")
                .basePath("/api/v2/users/forget-password")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(200);
    }

}