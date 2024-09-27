package com.automation.steps;

import com.automation.pojo.CreatePojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RequestSteps {
    @Given("user wants to call {string} end point")
    public void user_wants_to_call_end_point(String endPoint) {
        if(endPoint.contains("@")){
            endPoint=endPoint.replace("@id", ConfigReader.getConfig("id"));
        }
        RestAssuredUtils.setEndPoint(endPoint);
    }

    @Given("set header {string} to {string}")
    public void set_header_to(String key, String value) {
        RestAssuredUtils.setHeader(key,value);
    }

    @Given("set request body from the pojo_file {string}")
    public void set_request_body_from_the_pojo_file(String fileName) throws JsonProcessingException {
        String jsonPath = ConfigReader.getConfig("Json.Folder.path");
        String jsonBody = RestAssuredUtils.getDataFromFile(jsonPath+fileName);

        ObjectMapper om = new ObjectMapper();
        CreatePojo createPojo = om.readValue(jsonBody, CreatePojo.class);
        RestAssuredUtils.setBodyFromPojo(createPojo);
        
    }

    @When("user performs post call")
    public void user_performs_post_call() {
        RestAssuredUtils.post();
        
    }

    @And("user perform delete call")
    public void userPerformDeleteCall() {
        RestAssuredUtils.delete();
    }

    @And("user perform get call")
    public void userPerformGetCall() {

        RestAssuredUtils.get();
    }

    @And("set request body from the file {string}")
    public void setRequestBodyFromTheFile(String fileName) {
        RestAssuredUtils.setBody(fileName);
    }

    @And("user perform put call")
    public void userPerformPutCall() {
        RestAssuredUtils.put();
    }


}
