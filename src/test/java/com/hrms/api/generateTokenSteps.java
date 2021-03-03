package com.hrms.api;

import com.hrms.Utils.GlobalVariables;
import io.cucumber.java.en.Given;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;

import static io.restassured.RestAssured.given;

public class generateTokenSteps {
    public static String uri= GlobalVariables.baseURI;
    static String token;
    @Given("JWT is generated")
    public void jwt_is_generated() {

        RequestSpecification generateTokenRequest = given().header("Content-type", "application/json").body("{\"email\":\"Pokimane@gmail.com\",\"password\":\"Pikachu7\"}");
        Response generateTokenResponse = generateTokenRequest.when().post("/generateToken.php");
        generateTokenResponse.prettyPrint();
        token="Bearer "+generateTokenResponse.jsonPath().getString("token");
        System.out.println(token);
    }}