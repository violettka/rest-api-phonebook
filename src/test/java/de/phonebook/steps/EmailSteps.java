package de.phonebook.steps;

import io.cucumber.java.en.When;

public class EmailSteps extends BaseSteps {

    @When("I have random email")
    public void iHaveRandomEmail() {
        payload = apiHelper.createRandomEmailPayload(Integer.parseInt(idList.get(0)));
    }

    @When("I edit random email")
    public void iEditRandomEmail() {
        payload = apiHelper.editEmailPayload(Integer.parseInt(idList.get(0)));
    }
}
