package de.phonebook;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data // now we don't need any getters or setters
@JsonIgnoreProperties(ignoreUnknown = true)
public class ContactPojo {
    private int id;
    private String firstName;
    private String lastName;
}
