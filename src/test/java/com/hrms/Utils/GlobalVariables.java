package com.hrms.Utils;

import io.restassured.RestAssured;

import java.util.List;
import java.util.Map;

public class GlobalVariables {
    public static String emp_Id;
    public static List<Map<String, String>> dblist;
    public static List<String> jobTitlesFromDB;
    public static String baseURI = RestAssured.baseURI = "http://3.237.189.167/syntaxapi/api";
    public static String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQ3MzQ2NzUsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDc3Nzg3NSwidXNlcklkIjoiMjYzOCJ9.Gc9OQUm53UxrSRmXIg7-8oTARYoRYn2OXP_Tnp-_BmU";
}
