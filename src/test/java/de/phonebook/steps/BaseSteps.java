package de.phonebook.steps;

import de.phonebook.APIHelper;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.List;

public class BaseSteps {

    public APIHelper apiHelper = new APIHelper();
    public RequestSpecification request;
    public RequestSpecification authRequest;
    public static Response response;
    public static String payload;
    public static String token;
    public static List<String> idList;
}
