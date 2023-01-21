package de.phonebook.steps;

import de.phonebook.ContactPojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.stream.Collectors;

import static de.phonebook.Constants.BASE_URL;
import static io.restassured.RestAssured.given;

public class ContactSteps extends BaseSteps {

    @Given("I add new contact")
    public void iAddNewContact() {
        request = given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
        payload = apiHelper.createRandomContactPayload();
        response = request.body(payload).post(BASE_URL + "contact");
        response.then().assertThat().statusCode(201);
        contactId = response.getBody().jsonPath().getString("id");
    }

    @When("I send DELETE request to '{}' endpoint")
    public void iSendDELETERequestToContactEndpoint(String endpoint) {
        request = given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
        response = request.delete(BASE_URL + endpoint + contactId);
    }

    @When("I send GET request to '{}' endpoint")
    public void iSendGETRequestToContactsEndpoint(String endpoint) {
        List<ContactPojo> allContacts = getContacts();
        request = given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
        response = request.body(payload).when().get(BASE_URL + endpoint);
    }

    public static List<ContactPojo> getContacts() {
        return given().get().jsonPath().getList("contact", ContactPojo.class);
    }


    @Then("I get contact with {}")
    public void iGetContactWithName(String name) {
       ContactPojo elt = getContacts().stream()
               .filter(contactPojo -> name.equals(contactPojo.getFirstName()))
               .findAny()
               .orElse(null);
        contactId = response.getBody().jsonPath().getString("id");
    }

    public void iGetAllContactsWithName(String name) {
        List<ContactPojo> elt = getContacts().stream()
                .filter(contactPojo -> name.equals(contactPojo.getFirstName()))
                .collect(Collectors.toList());

    }
}
