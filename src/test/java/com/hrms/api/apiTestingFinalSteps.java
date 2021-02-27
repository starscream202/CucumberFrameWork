package com.hrms.api;

import com.hrms.Utils.APIConstants;
import com.hrms.Utils.APIPayloadConstants;
import com.hrms.Utils.GlobalVariables;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class apiTestingFinalSteps {
    public RequestSpecification request;
    public Response response;
    public static String id;
    @When("get POST call to create employee")
    public void get_POST_call_to_create_employee() {
        request = given().header(APIConstants.CONTENT_TYPE, APIConstants.Application_JSON).header(APIConstants.AUTHORIZATION, generateTokenSteps.token).body(APIPayloadConstants.createEmployeeBody());
    }

    @Then("the status code for creating employee is {int}")
    public void the_status_code_for_creating_employee_is(Integer int1) {
        response=request.when().post(APIConstants.CREATE_EMPLOYEE);
        response.then().assertThat().statusCode(201);
    }

    @Then("the employee is created")
    public void the_employee_is_created() {
        response.then().assertThat().body("Message",equalTo("Entry Created"));
    }

    @Then("Store employee ID")
    public void store_employee_ID() {
         id=response.jsonPath().getString("Employee[0].employee_id");
        System.out.println(id);
    }

    @When("request is prepared to retrieve created employee")
    public void request_is_prepared_to_retrieve_created_employee() {
        request=given().header(APIConstants.AUTHORIZATION,generateTokenSteps.token).header(APIConstants.CONTENT_TYPE,APIConstants.Application_JSON).queryParam("employee_id","16665A");
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
    }

    @Then("the retrieved data matched the data used to create the employee")
    public void the_retrieved_data_matched_the_data_used_to_create_the_employee() {
        response.then().assertThat().body("employee[0].employee_id",equalTo(id));
    }

}
