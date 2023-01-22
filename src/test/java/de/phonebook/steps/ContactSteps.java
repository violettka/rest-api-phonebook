package de.phonebook.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

import static de.phonebook.Constants.BASE_URL;

public class ContactSteps extends BaseSteps{

    @Given("I add new contact")
    public void iAddNewContact() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
        payload = apiHelper.createRandomContactPayload();
        response = request.body(payload).post(BASE_URL + "contact");
        response.then().assertThat().statusCode(201);
        contactID = response.getBody().jsonPath().getString("id");
    }

    @When("I send DELETE request to '{}' endpoint")
    public void iSendDELETERequestToContactEndpoint(String endpoint) {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
        response = request.delete(BASE_URL + endpoint + contactID);
    }
}
