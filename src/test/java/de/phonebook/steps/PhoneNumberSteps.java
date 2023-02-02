package de.phonebook.steps;

import com.sun.jdi.IntegerType;
import groovyjarjarantlr4.v4.runtime.misc.IntegerList;
import groovyjarjarantlr4.v4.runtime.misc.IntegerStack;
import io.cucumber.core.internal.com.fasterxml.jackson.databind.ser.std.NumberSerializers;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.codehaus.groovy.runtime.dgmimpl.arrays.IntegerArrayGetAtMetaMethod;
import org.codehaus.groovy.runtime.typehandling.IntegerMath;

public class PhoneNumberSteps extends BaseSteps {

    @When("I have random phone number")
    public void iAddRandomPhoneNumber() {
        payload = apiHelper.createRandomPhoneNumberPayload(Integer.parseInt(idList.get(0)));
    }

    @When("I edit phone number")
    public void iEditPhoneNumber() {
      payload = apiHelper.editPhoneNumberPayload(Integer.parseInt(idList.get(0)));
    }
}
