package bosta.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiClient {
    public static RequestSpecification getBaseRequest() {
        return new RequestSpecBuilder()
                .setBaseUri("https://stg-app.bosta.co")
                .setBasePath("/api/v2/pickups")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6Ik1uN3FpVk9jQnFiWlNaTUFwbzFMdyIsInJvbGVzIjpbIkJVU0lORVNTX0FETUlOIl0sImJ1c2luZXNzQWRtaW5JbmZvIjp7ImJ1c2luZXNzSWQiOiJBWG5keU5kbXh6V2EweHVFdVJycmIiLCJidXNpbmVzc05hbWUiOiLYqtiz2Kog2KjYstmG2LMifSwiY291bnRyeSI6eyJfaWQiOiI2MGU0NDgyYzdjYjdkNGJjNDg0OWM0ZDUiLCJuYW1lIjoiRWd5cHQiLCJuYW1lQXIiOiLZhdi12LEiLCJjb2RlIjoiRUcifSwiZW1haWwiOiJtb2hhbWVkLmVsa2hvbGFleSsxQGJvc3RhLmNvIiwicGhvbmUiOiIrMjAxMjAyNDM2MzA5IiwiZ3JvdXAiOnsiX2lkIjoiWGFxbENGQSIsIm5hbWUiOiJCVVNJTkVTU19GVUxMX0FDQ0VTUyIsImNvZGUiOjExNX0sInRva2VuVHlwZSI6IkFDQ0VTUyIsInRva2VuVmVyc2lvbiI6IlYyIiwic2Vzc2lvbklkIjoiMDFKUldKNDgzQVNGODQ2NktEWFBZWkZNUTIiLCJpYXQiOjE3NDQ3MTUyNjAsImV4cCI6MTc0NTkyNDg2MH0.jjFo0wZ1Dx8_mpA2tFPD3bsqVClRVxo4CWnFS2E3tpg")
                .addHeader("Content-Type", "application/json")
                .build();
    }
}
