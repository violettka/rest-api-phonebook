package de.phonebook.steps;

import io.cucumber.java.en.When;

public class PhoneSteps extends BaseSteps {

    @When("I add random phone number")
    public void iAddRandomPhoneNumber() {
        payload = apiHelper.createRandomPhoneNumberPayload(Integer.parseInt(idList.get(0)));
    }
}
