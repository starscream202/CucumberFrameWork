package com.hrms.apiTesting;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class hardCodedExamples {
    @Test
    public void sampleTest(){
        RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
        String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTM5MzQyMTcsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxMzk3NzQxNywidXNlcklkIjoiMjM5MCJ9.0CXXRXxR_SzkZf7FaO7I02YxYMdJ_YRc01Nerr4b95A";
        //preparing request to get one employee
        RequestSpecification getOneEmployeeRequest=given().header("Authorization",token).header("Content-Type","Application/json")
        .queryParam("employee_id","13014");
        Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
        System.out.println(getOneEmployeeResponse.asString());
    }
}

