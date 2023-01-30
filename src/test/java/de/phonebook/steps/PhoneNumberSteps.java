package de.phonebook.steps;

import io.cucumber.java.en.When;

public class PhoneNumberSteps extends BaseSteps {

    @When("I have random phone number")
    public void iAddRandomPhoneNumber() {
        payload = apiHelper.createRandomPhoneNumberPayload(Integer.parseInt(idList.get(0)));
    }
}
