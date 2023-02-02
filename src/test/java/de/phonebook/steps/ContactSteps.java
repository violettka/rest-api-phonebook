package de.phonebook.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;

import static de.phonebook.Constants.BASE_URL;

public class ContactSteps extends BaseSteps {

    @Given("I add random contact")
    public void iAddRandomContact() {
        authRequest = apiHelper.createBaseRequestWithToken(token);
        payload = apiHelper.createRandomContactPayload();
        response = authRequest.body(payload).post(BASE_URL + "contact");
        response.then().assertThat().statusCode(201);
        idList = Arrays.asList(response.getBody().jsonPath().getString("id"));
    }

    @When("I send DELETE request to '{}' endpoint")
    public void iSendDELETERequestToContactEndpoint(String endpoint) {
        request = apiHelper.createBaseRequestWithToken(token);
        for (int i = 0; i < idList.size(); i++) {
            String contactsID = String.valueOf(idList.get(i));
            response = request.delete(BASE_URL + endpoint + contactsID);
        }
    }

    @When("I send GET request to '{}' endpoint")
    public void iSendGETRequestToContactsEndpoint(String endpoint) {
        request = apiHelper.createBaseRequestWithToken(token);
        response = request.body(payload).when().get(BASE_URL + endpoint);
    }

    @Given("I add a few '{}' contacts")
    public void iAddAFewContacts(String lastname) {
        request = apiHelper.createBaseRequestWithToken(token);
        payload = apiHelper.createContactPayload(lastname);
        for (int i = 0; i < 3; i++) {
            response = request.body(payload).post(BASE_URL + "contact");
            response.then().assertThat().statusCode(201);
        }
    }

    @When("I get id list of '{}' contacts")
    public void iGetIdListOfContacts(String lastname) {
        idList = response.jsonPath().getList("findAll { a -> a.lastName == '" + lastname + "' }.id");
    }

    @Then("I see none '{}' contacts")
    public void iSeeAFewContacts(String lastname) {
        iGetIdListOfContacts(lastname);
        Assertions.assertTrue(idList.isEmpty());
    }

    @When("I send PUT request to '{}' endpoint")
    public void iSendPUTRequestToContactEndpoint(String endpoint) {
        request = apiHelper.createBaseRequestWithToken(token);
        response = request.body(payload).when().put(BASE_URL + endpoint);
    }

    @When("I edit random contact")
    public void iEditRandomContact() {
        payload = apiHelper.editContactPayload(Integer.parseInt(idList.get(0)));
    }

    @Then("I see added random contact")
    public void iSeeAddedRandomContact() {
        response.then().assertThat().equals(BASE_URL + "contact");
    }
}
