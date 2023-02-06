package de.phonebook.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import org.hamcrest.core.Is;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static de.phonebook.Constants.BASE_URL;
import static org.hamcrest.CoreMatchers.containsString;


public class ContactSteps extends BaseSteps{
    @Given("I add new '{}' contact")
    public void iAddNewContact(String contact_type) {
        request = apiHelper.createBaseRequestWithToken(token);
        if (contact_type.equals("random")){
            payload = apiHelper.createRandomContactPayload();
        } else {
            payload = apiHelper.createContactPayload(contact_type);
        }
        response = request.body(payload).post(BASE_URL + "contact");
        response.then().assertThat().statusCode(201);
        contactID = response.getBody().jsonPath().getString("id");
    }

    @When("I send DELETE request to '{}' endpoint")
    public void iSendDELETERequestToContactEndpoint(String endpoint) {
        request = apiHelper.createBaseRequestWithToken(token);
        response = request.delete(BASE_URL + endpoint + contactID);
    }

    @When("I send GET request to '{}' endpoint")
    public void iSendGETRequestToEndpoint(String endpoint) {
        request = apiHelper.createBaseRequestWithToken(token);
        response = request.get(BASE_URL + endpoint);
    }

    @Then("I see {} '{}' contact")
    public void iSeeAtLeastOneContact(String contact_amount, String contact_name) {
        iExtractBulkContactsIDs(contact_name);
        if (contact_amount.equals("at least one")) {
            Assertions.assertTrue(idList.size() >1 );
        } else if (contact_amount.equals("none")) {
            Assertions.assertTrue(idList.isEmpty() );
        }
    }

    @When("I extract '{}' bulk contact IDs")
    public void iExtractBulkContactsIDs(String contact_name) {
        String[] name = contact_name.split(" ", 2);
       idList = response.jsonPath().getList("findAll { a -> a.lastName == '" + contact_name + "' }.id");
    }
}
