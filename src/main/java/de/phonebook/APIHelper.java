package de.phonebook;

import com.github.javafaker.Faker;
import com.google.gson.JsonObject;
import groovy.json.JsonException;

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
}
