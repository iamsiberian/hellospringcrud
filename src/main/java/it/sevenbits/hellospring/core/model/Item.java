package it.sevenbits.hellospring.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private final long number;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public Item(
            @JsonProperty("number") long number,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("LastName") String lastName) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getNumber() {
        return number;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

}
