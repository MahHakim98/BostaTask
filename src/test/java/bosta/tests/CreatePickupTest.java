package bosta.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class CreatePickupTest {

    @Test
    public void createPickup() {
        String token = "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Ik1uN3FpVk9jQnFiWlNaTUFwbzFMdyIsInJvbGVzIjpbIkJVU0lORVNTX0FETUlOIl0sImJ1c2luZXNzQWRtaW5JbmZvIjp7ImJ1c2luZXNzSWQiOiJBWG5keU5kbXh6V2EweHVFdVJycmIiLCJidXNpbmVzc05hbWUiOiLYqtiz2Kog2KjYstmG2LMifSwiY291bnRyeSI6eyJfaWQiOiI2MGU0NDgyYzdjYjdkNGJjNDg0OWM0ZDUiLCJuYW1lIjoiRWd5cHQiLCJuYW1lQXIiOiLZhdi12LEiLCJjb2RlIjoiRUcifSwiZW1haWwiOiJtb2hhbWVkLmVsa2hvbGFleSsxQGJvc3RhLmNvIiwicGhvbmUiOiIrMjAxMjAyNDM2MzA5IiwiZ3JvdXAiOnsiX2lkIjoiWGFxbENGQSIsIm5hbWUiOiJCVVNJTkVTU19GVUxMX0FDQ0VTUyIsImNvZGUiOjExNX0sInRva2VuVHlwZSI6IkFDQ0VTUyIsInRva2VuVmVyc2lvbiI6IlYyIiwic2Vzc2lvbklkIjoiMDFKUldKNDgzQVNGODQ2NktEWFBZWkZNUTIiLCJpYXQiOjE3NDQ3MTUyNjAsImV4cCI6MTc0NTkyNDg2MH0.jjFo0wZ1Dx8_mpA2tFPD3bsqVClRVxo4CWnFS2E3tpg";

        // Updated request body with SQL Injection and XSS Payloads
        String requestBody = """
        {
          "businessLocationId": "' UNION SELECT null, null, null --", 
          "contactPerson": {
            "_id": "pvE7i1MA_8",
            "name": "<script>alert('XSS in Name Field')</script>",  
            "phone": "+201202436309"
          },
          "scheduledDate": "2025-04-15",
          "numberOfParcels": "3",
          "hasBigItems": false,
          "repeatedData": {
            "repeatedType": "<script>alert('XSS in RepeatedType')</script>"  
          },
          "creationSrc": "Web"
        }
        """;
        RestAssured
                .given()
                .baseUri("https://stg-app.bosta.co")
                .basePath("/api/v2/pickups")
                .contentType(ContentType.JSON)
                .header("authorization", token) // Token here, no need to prefix "Bearer " explicitly
                .header("accept", "application/json, text/plain, */*")
                .header("accept-language", "en")
                .header("origin", "https://stg-business.bosta.co")
                .header("priority", "u=1, i")
                .header("referer", "https://stg-business.bosta.co/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"135\", \"Not-A.Brand\";v=\"8\", \"Chromium\";v=\"135\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("sec-ch-ua-platform", "\"Linux\"")
                .header("sec-fetch-dest", "empty")
                .header("sec-fetch-mode", "cors")
                .header("sec-fetch-site", "same-site")
                .header("user-agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/135.0.0.0 Safari/537.36")
                .header("x-device-fingerprint", "rvmsmy")
                .header("x-device-id", "eyJpcCI6IjQ1LjI0Mi43Ni4xNTUiLCJmaW5nZXJwcmludCI6InVibjF3MyIsInVzZXJBZ2VudCI6Ik1vemlsbGEvNS4wIChYMTE7IExpbnV4IHg4Nl82N CkgQXBwbGVXZWJLaXQvNTM3LjM2IChLSFRNTCwgbGlrZSBHZWNrbykgQ2hyb21lL zEzMS4wLjAuMCBTYWZhcmkvNTM3LjM2In0=")
                .body(requestBody)  // Updated body with SQL and XSS injections
                .when()
                .post()
                .then()
                .log().all()
                .statusCode(201); // Expecting a successful response with 201 Created
    }
}