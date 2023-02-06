package de.phonebook.steps;

import io.cucumber.java.en.When;

public class AddressSteps extends BaseSteps {

    @When("I have random address")
    public void iHaveRandomAddress() {
        payload = apiHelper.createRandomAddressPayload(Integer.parseInt(idList.get(0)));
    }

    @When("I edit random address")
    public void iEditRandomAddress() {
        payload = apiHelper.editAddressPayload(Integer.parseInt(idList.get(0)));
    }
}
