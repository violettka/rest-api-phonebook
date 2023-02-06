package de.phonebook.steps;

import de.phonebook.APIHelper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static de.phonebook.Constants.BASE_URL;

public class LoginSteps extends BaseSteps{

    @Given("I have a valid user credentials")
    public void iHaveRandomUser(){
        request = RestAssured.given()
                .header("Content-Type", "application/json");
        payload = apiHelper.createUserPayload();
    }


    @When("I send POST request to '{}' endpoint")
    public void iSendPOSTRequestToEndpoint(String endpoint) {
        request = RestAssured.given()
                .header("Content-Type", "application/json");
        payload = apiHelper.createUserPayload();
        response = request.body(payload).when().post(BASE_URL + endpoint);
    }

    @Then("I see the status code {}")
    public void iSeeTheStatusCode(Integer statusCode) {
        response.then().assertThat().statusCode(statusCode);
    }

    @Given("I have a valid access token")
    public void iHaveAValidAccessToken() {
        iHaveRandomUser();
        iSendPOSTRequestToEndpoint("user/login");
        iSeeTheStatusCode(200);
        token =  response.getHeader("Access-Token");
    }
}
