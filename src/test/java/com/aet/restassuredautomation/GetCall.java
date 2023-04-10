package com.aet.restassuredautomation;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetCall {
    @Test
    public void getApiCall() {

       /* RestAssured.given().baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .get();*/
        Response res = RestAssured.given().log().all()
                .baseUri("https://api.instantwebtools.net/v1/airlines")
                .contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"id\": 121212121212121212,\n" +
                        "    \"name\": \"INDIAN Airways\",\n" +
                        "    \"country\": \"INDIA\",\n" +
                        "    \"logo\": \"https://upload.wikimedia.org/wikipedia/en/thumb/9/9b/Qatar_Airways_Logo.svg/sri_lanka.png\",\n" +
                        "    \"slogan\": \"From Sri Lanka\",\n" +
                        "    \"head_quaters\": \"Delhi\",\n" +
                        "    \"website\": \"www.India.com\",\n" +
                        "    \"established\": \"1995\"\n" +
                        "}")
                .post()
                .then().log().all().extract().response();

        Assert.assertEquals(res.statusCode(), 200);


    }

}
