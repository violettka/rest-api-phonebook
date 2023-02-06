package de.phonebook;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import groovy.json.JsonException;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static de.phonebook.Constants.VALID_USER;

public class APIHelper {

    Faker faker = new Faker();
    JsonObject payload = new JsonObject();

    public String createUserPayload() throws JsonException {
        payload.addProperty("email", VALID_USER);
        payload.addProperty("password", VALID_USER);
        return payload.toString();
    }

    public String createRandomContactPayload() {
        payload.addProperty("firstName", faker.name().firstName());
        payload.addProperty("lastName", faker.name().lastName());
        payload.addProperty("description", faker.animal().name());
        return payload.toString();
    }

    public String createRandomPhoneNumberPayload(int contactId) {
        payload.addProperty("countryCode", "+49");
        payload.addProperty("phoneNumber", faker.phoneNumber().subscriberNumber(8));
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }

    public RequestSpecification createBaseRequestWithToken(String token) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
    }

    public String createContactWithLastnamePayload(String lastname) {
        payload.addProperty("firstName", faker.name().firstName());
        payload.addProperty("lastName", lastname);
        payload.addProperty("description", faker.pokemon().name());
        return payload.toString();
    }

    public String createRandomPhoneNumberPayload(int contactId) {
        payload.addProperty("countryCode", "+49");
        payload.addProperty("phoneNumber", faker.phoneNumber().subscriberNumber(8));
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }

    public String createRandomEmailPayload(int contactId) {
        payload.addProperty("email", faker.internet().emailAddress());
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }

    public String createRandomAddressPayload(int contactId) {
        payload.addProperty("contactId", contactId);
        payload.addProperty("country", faker.pokemon().name());
        payload.addProperty("street", faker.pokemon().name());
        payload.addProperty("city", faker.pokemon().name());
        payload.addProperty("zip", faker.phoneNumber().subscriberNumber(3));
        return payload.toString();
    }

    public String editContactPayload(int id) {
        payload.addProperty("firstName", faker.name().firstName());
        payload.addProperty("lastName", faker.name().lastName());
        payload.addProperty("description", faker.pokemon().name());
        payload.addProperty("id", id);
        return payload.toString();
    }

    public String editAddressPayload(int contactId) {
        payload.addProperty("id", 96);
        payload.addProperty("city", faker.pokemon().name());
        payload.addProperty("country", faker.pokemon().name());
        payload.addProperty("street", faker.pokemon().name());
        payload.addProperty("zip", faker.phoneNumber().subscriberNumber(3));
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }

    public String editPhoneNumberPayload(int contactId) {
        payload.addProperty("id", faker.number().numberBetween(1,200));
        payload.addProperty("countryCode", "+49");
        payload.addProperty("phoneNumber", faker.phoneNumber().subscriberNumber(8));
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }

    public String editEmailPayload(int contactId) {
       payload.addProperty("id", faker.number().numberBetween(1,200));
        payload.addProperty("email", faker.internet().emailAddress());
        payload.addProperty("contactId", contactId);
        return payload.toString();
    }
}
