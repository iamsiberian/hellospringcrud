package it.sevenbits.hellospring.core.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
    private final long id;
    private final String firstName;
    private final String lastName;

    @JsonCreator
    public Item(
            @JsonProperty("id") long id,
            @JsonProperty("firstName") String firstName,
            @JsonProperty("lastName") String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @JsonProperty("id")
    public long getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }

}
