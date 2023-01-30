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

    public RequestSpecification createBaseRequestWithToken(String token) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
    }

    public String createContactPayload(String lastname) {
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
}
