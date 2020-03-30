package com.decider.decider.core.domain;

import lombok.AllArgsConstructor;

import java.util.Date;

@AllArgsConstructor
public class Person {
    private final long id;

    private final String firstName;

    private final String lastName;

    private final Date birthdate;

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
