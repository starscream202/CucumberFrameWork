package com.hrms.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.hrms.Utils.APIConstants;
import com.hrms.Utils.APIPayloadConstants;
import com.hrms.Utils.CommonMethods;
import com.hrms.Utils.GlobalVariables;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.io.File;
import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public  class apiTestingFinalSteps {
    public RequestSpecification request;
    public static Response response;
    public static String id;

    public static String returnID(){
        id=response.jsonPath().getString("Employee[0].employee_id");
        return id;
    }
    //Test 1
    @When("get POST call to create employee")
    public void get_POST_call_to_create_employee() {
        request = given().header(APIConstants.CONTENT_TYPE, APIConstants.Application_JSON).header(APIConstants.AUTHORIZATION, generateTokenSteps.token).body(APIPayloadConstants.createEmployeeBody()).log().all();
    }

    @Then("the status code for creating employee is {int}")
    public void the_status_code_for_creating_employee_is(Integer int1) {
        response=request.when().post(APIConstants.CREATE_EMPLOYEE);
        response.then().assertThat().statusCode(201);
        response.prettyPrint();
    }

    @Then("the employee is created")
    public void the_employee_is_created() {
        response.then().assertThat().body("Message",equalTo("Employee Created"));
    }

    @Then("Store employee ID")
    public void store_employee_ID() {
         id=response.jsonPath().getString("Employee.employee_id");
        System.out.println(id);
    }
    //test 2
    @When("request is prepared to retrieve created employee")
    public void request_is_prepared_to_retrieve_created_employee() {
        request=given().header(APIConstants.AUTHORIZATION,generateTokenSteps.token).header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON).queryParam("employee_id",id);
    }

    @Then("a get call is made")
    public void a_get_call_is_made() {
        response=request.when().get(APIConstants.GET_ONE_EMPLOYEE);
        System.out.println(response.prettyPrint());
    }

    @Then("Status code for retrieving created employee is {int}")
    public void status_code_for_retrieving_created_employee_is(Integer statuscode) {
        response.then().assertThat().statusCode(200);
    }

    @Then("the retrieved EmployeeID matches the globally stored EmployeeID")
    public void the_retrieved_EmployeeID_matches_the_globally_stored_EmployeeID() {
        id=response.jsonPath().getString("employee[0].employee_id");
        System.out.println(id);
    }

    @Then("the retrieved data matched the data used to create the employee")
    public void the_retrieved_data_matched_the_data_used_to_create_the_employee() {
        response.then().assertThat().body("employee[0].employee_id",equalTo(id));
    }
    //test 3
    @Given("request to update employee")
    public void request_to_update_employee() {

        request=given().header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON)
                .header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .body(APIPayloadConstants.updateEmployee()).log().all();
    }

    @When("a put call is made to update employee")
    public void a_put_call_is_made_to_update_employee() {
        response=request.when().patch(APIConstants.PARTIAL_UPDATE_EMPLOYEE);
        System.out.println(response.prettyPrint());
    }

    @Then("status code is {int}")
    public void status_code_is(Integer value) {
        response.then().assertThat().statusCode(value);
    }

    @Then("The updated employee contains key {string} and the value {string}")
    public void the_updated_employee_contains_key_and_the_value(String Message, String EntryUpdated) {
        response.then().assertThat().body(Message,equalTo(EntryUpdated));
    }

    //test 5
    @Given("request is made to delete employee")
    public void request_is_made_to_delete_employee() {
        request=given().header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON)
                .queryParam("employee_id",id);
    }

    @When("delete call is made")
    public void delete_call_is_made() {
        response=request.when().delete(APIConstants.DELETE_EMPLOYEE);
    }

    @Then("the status code is {int}")
    public void the_status_code_is(Integer value) {
        response.then().assertThat().statusCode(value);
    }

    @Then("employee is successfully deleted with the {string} in response {string}")
    public void employee_is_successfully_deleted_with_the_in_response(String message, String entry) {
        response.then().assertThat().body(message,equalTo(entry));
    }

    @Then("the {string} is same as one in gloabl")
    public void the_is_same_as_one_in_gloabl(String emp_id) {
        response.then().assertThat().body(emp_id,equalTo(id));
    }
    //test 6
    @Given("request is made to get all employees")
    public void request_is_made_to_get_all_employees() {
        request=given().header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON);
    }

    @When("a get call is made to get all employees")
    public void a_get_call_is_made_to_get_all_employees() {
       response=request.when().get(APIConstants.GET_ALL_EMPLOYEES);
    }

    @Then("employees are successfully retrieved with {string} and {string}")
    public void employees_are_successfully_retrieved_with_and(String total, String emp) {
        response.then().assertThat().body(containsString(total)).body(containsString(emp));
        String payload=response.asString();
        JsonPath js= new JsonPath(payload);
        int count = js.getInt("Employees.size()");
        for (int i=0; i<count;i++){
            String allEmployeesID= js.getString("Employees["+i+"].employee_id");
            System.out.println(allEmployeesID);
        }

    }

    //test 7
    @Given("request is made to get all job titles")
    public void request_is_made_to_get_all_job_titles() {
        request=given().header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON).log().all();
    }

    @When("get call is made to get all job titles")
    public void get_call_is_made_to_get_all_job_titles() {
        response=request.when().get(APIConstants.JOB_TITLE);
    }

    @Then("assert that status code is {int}")
    public void assert_that_status_code_is(Integer expected) {
        response.then().statusCode(expected);
    }

    @Then("response has {string}")
    public void response_has(String List) {
        response.prettyPrint();
        response.then().assertThat().body(containsString(List));
    }

    //update employee api test
    @Given("request to update employee {int}")
    public void request_to_update_employee(Integer int1) throws FileNotFoundException {
        request=given().header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON)
                .header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .body(APIPayloadConstants.update_Employee()).log().all();
    }
    @When("a put call is made to update Employee")
    public void a_put_call_is_made_to_update_Employee() {
        response=request.when().put(APIConstants.UPDATE_EMPLOYEE);
    }

    @Then("assert that response has {string} and {string}")
    public void assert_that_response_has_and(String Message, String expected) {
        response.then().assertThat().body(Message,equalTo(expected));
    }

    //getting employee statuses
    @Given("request is made to get employee statuses")
    public void request_is_made_to_get_employee_statuses() {
        request=given().header(APIConstants.CONTENT_TYPE, APIConstants.Application_JSON)
                .header(APIConstants.AUTHORIZATION,generateTokenSteps.token)
                .log().all();
    }

    @When("get call is made to get statuses")
    public void get_call_is_made_to_get_statuses() {
        response=request.when().get(APIConstants.EMPLOYEE_STATUS);
        response.prettyPrint();
    }
    @Then("assert the response matches")
    public void assert_the_response_matches() {
        String expected="Employee Status List";
        response.then().assertThat().body(containsString(expected));
    }






}
