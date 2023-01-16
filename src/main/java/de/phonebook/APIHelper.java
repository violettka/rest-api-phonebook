package de.phonebook;

import com.google.gson.JsonObject;
import groovy.json.JsonException;

import static de.phonebook.Constants.VALID_USER;

public class APIHelper {

    public String createUserPayload() throws JsonException{
        JsonObject payload = new JsonObject();
        payload.addProperty("email", VALID_USER);
        payload.addProperty("password", VALID_USER);
        return payload.toString();
    }

}
