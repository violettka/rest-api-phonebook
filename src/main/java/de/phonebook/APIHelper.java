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
    public String createUserPayload() throws JsonException{
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
//
//    public addPhoneNumber(String contactId){
//        payload.addProperty("countryCode", "+49");
//        payload.addProperty("phoneNumber", faker.phoneNumber().cellPhone());
//        payload.addProperty("contactId", contactId);
//    }

    public RequestSpecification createBaseRequestWithToken(String token) {
        return RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Access-Token", token);
    }

    public String createContactPayload(String contact_type) {
        String[] name = contact_type.split(" ", 2);
        payload.addProperty("firstName", name[0]);
        payload.addProperty("lastName", name[1]);
        payload.addProperty("description", faker.animal().name());
        return payload.toString();
    }
}
