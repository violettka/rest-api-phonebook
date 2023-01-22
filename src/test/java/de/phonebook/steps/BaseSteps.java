package de.phonebook.steps;

import de.phonebook.APIHelper;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseSteps {
    public APIHelper apiHelper = new APIHelper();
    public RequestSpecification request;
    public static Response response;
    public static String payload;
    public static String token;
    public static String contactID;


}
