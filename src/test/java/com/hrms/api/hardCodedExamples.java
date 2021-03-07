package com.hrms.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hrms.TestBase.BaseClass;
import com.hrms.Utils.APIConstants;
import com.hrms.Utils.APIPayloadConstants;
import com.hrms.Utils.GlobalVariables;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.minidev.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.hamcrest.CoreMatchers.*;

import static io.restassured.RestAssured.*;

public class hardCodedExamples {
    public static String URI=GlobalVariables.baseURI;
    @Test
    public void sampleTest(){
        RestAssured.baseURI="http://3.237.189.167/syntaxapi/api";
        String token="Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MTQxMjY1NTYsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYxNDE2OTc1NiwidXNlcklkIjoiMjM5MCJ9.QIkM76dVQ9PpUG1I5QuRiZGOawuaPEOW0dx9NFmdwDM";
        //preparing request to get one employee
        RequestSpecification getOneEmployeeRequest=given().header("Authorization",token).header("Content-Type","Application/json")
        .queryParam("employee_id","20001.0");
        Response getOneEmployeeResponse = getOneEmployeeRequest.when().get("/getOneEmployee.php");
        System.out.println(getOneEmployeeResponse.asString());
        getOneEmployeeResponse.then().assertThat().statusCode(200);
        getOneEmployeeResponse.prettyPrint();

    }
    @Test
    public void aPostCreateEmployee(){
        String uri=GlobalVariables.baseURI;
        RequestSpecification createEmployeRequest=given().header("Authorization", GlobalVariables.token).header("Content-Type","Application/json").body("{\n" +
                "  \"emp_firstname\": \"Nagato\",\n" +
                "  \"emp_lastname\": \"Pain\",\n" +
                "  \"emp_middle_name\": null,\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2021-02-11\",\n" +
                "  \"emp_status\": \"employee\",\n" +
                "  \"emp_job_title\": \"IT Analyst\"\n" +
                "}");
        Response createEmployeeResponse= createEmployeRequest.when().post("/createEmployee.php");
        createEmployeeResponse.prettyPrint();
        createEmployeeResponse.then().assertThat().statusCode(201);
        JsonPath r=createEmployeeResponse.jsonPath();
        r.prettyPrint();
        String id=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        System.out.println(id);
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
    }
    @Test
    public void aPutUpdateEmployee(){
        String uri=GlobalVariables.baseURI;
        JSONObject requestParams = new JSONObject();
        requestParams.put("employee_id", "13927"); // Cast
        requestParams.put("emp_middle_name", "NineTailedFox");
        requestParams.put("emp_gender","M");
        RequestSpecification updateEmployeeRequest=given().header("Authorization",GlobalVariables.token).header("Content_Type","Application/json").body(requestParams.toJSONString());

        Response updateEmployeeResponse=updateEmployeeRequest.when().put("/updatePartialEmplyeesDetails.php");
        updateEmployeeResponse.prettyPrint();
    }
    @Test
    public void getCreatedEmployee(){
        //created string for base URI
        String uri=GlobalVariables.baseURI;
       //creating request
        RequestSpecification getCreatedEmployeeRequest= given().header("Authorization", GlobalVariables.token).header("Content-Type","Application/json").queryParam("employee_id","13933");
       //creating response
        Response getCreatedEmployeeResponse=getCreatedEmployeeRequest.when().get("/getOneEmployee.php");
       //asserting using then()
        getCreatedEmployeeResponse.then().assertThat().body("employee[0].emp_firstname",equalTo("Madara"));
       getCreatedEmployeeResponse.prettyPrint();
       String id =getCreatedEmployeeResponse.body().jsonPath().getString("employee[0].employee_id");
       //asserting with boolean
       boolean verifyingID=id.equalsIgnoreCase("13933");
        Assert.assertTrue(verifyingID);
    }

    @Test
    public void getAllEmployees(){//playing around

        RequestSpecification getAllEmployeesRequest= given().header("Authorization",GlobalVariables.token).header("Content-Type","Application/json");
        Response getAllEmployeesResponse=getAllEmployeesRequest.when().get("/getAllEmployees.php");
        int intStatusCode=getAllEmployeesResponse.statusCode();
        getAllEmployeesResponse.then().assertThat().statusCode(200).equals(intStatusCode);
        JsonParser parser= new JsonParser();
        String responseAsString=getAllEmployeesResponse.asString();
        JsonObject response_getAllEmp= JsonParser.parseString(responseAsString).getAsJsonObject();
        JsonArray array_GetAllEmp= response_getAllEmp.get("Employees").getAsJsonArray();

        for(JsonElement x: array_GetAllEmp){
            JsonObject Employee_Data=x.getAsJsonObject();
            String emp_Firstname= Employee_Data.get("emp_firstname").getAsString();
            String emp_ID=Employee_Data.get("employee_id").getAsString();
            System.out.println(emp_Firstname+" "+emp_ID);
        }

        //getAllEmployeesResponse.prettyPrint();

    }

    @Test
    public void getAllStatus(){

        RequestSpecification getAllStatusRequest= given().header(APIConstants.AUTHORIZATION,GlobalVariables.token)
                .header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON)
                .log().all();

        Response response=getAllStatusRequest.when().get(APIConstants.EMPLOYEE_STATUS);

        response.prettyPrint();
    }
    @Test
    public void testingFileParse2() throws FileNotFoundException {
        File input=new File("C:\\Users\\stars\\eclipse-workspace\\MyFirstJava\\src\\com\\CucumberFramework\\src\\test\\resources\\features\\JsonData\\anotherJson.json");
        try{
            JsonElement fileElement= JsonParser.parseReader(new FileReader(input));
            JsonObject createUserData=fileElement.getAsJsonObject();
            JsonElement element=createUserData.get("Team 7");
            JsonArray array=element.getAsJsonArray();
            //as json object
            System.out.println(createUserData);
            //as json array
            System.out.println(array.get(0));
            System.out.println(array.get(1));
            System.out.println(array.get(2));
            //as json element
            JsonElement element1=array.get(0);
            System.out.println(element);
            System.out.println(element1);

        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }

    @Test
    public void testingFileParse() throws FileNotFoundException {
        File input=new File("C:\\Users\\stars\\eclipse-workspace\\MyFirstJava\\src\\com\\CucumberFramework\\src\\test\\resources\\features\\JsonData\\createUser.json");
        try{
            JsonElement fileElement= JsonParser.parseReader(new FileReader(input));
            JsonObject createUserData=fileElement.getAsJsonObject();
            JsonElement element=createUserData.get("Message");
            System.out.println(element);
            String emp_firstname=createUserData.get("emp_firstname").getAsString();
            JsonElement emp_firstnameAsElement=createUserData.get("emp_lastname");
            System.out.println("The json data to create user "+"    "+createUserData);
            System.out.println(fileElement);
            System.out.println("Employee first name is "+emp_firstnameAsElement);
            System.out.println("Employee first name is "+emp_firstname);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }


    }
    @Test
    public void parsingTest(){
        String uri=GlobalVariables.baseURI;
        RequestSpecification createEmployeRequest=given().header("Authorization", GlobalVariables.token).header("Content-Type","Application/json").body(APIPayloadConstants.createEmployeeAsString());



        Response createEmployeeResponse= createEmployeRequest.when().post("/createEmployee.php");
        createEmployeeResponse.prettyPrint();
        createEmployeeResponse.then().assertThat().statusCode(201);
        JsonPath r=createEmployeeResponse.jsonPath();

        r.prettyPrint();
        String id=createEmployeeResponse.jsonPath().getString("Employee[0].employee_id");
        System.out.println(id);
        createEmployeeResponse.then().assertThat().body("Message",equalTo("Entry Created"));
    }

}

