package com.example.numbers.domain;

public class Student {
    private String firstName;
    private String lastName;
    private String indexNumber;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public Student(String firstName, String lastName, int indexNumberLength) {
        this.firstName = firstName;
        this.lastName = lastName;
        RandomStringGenerator generator = new RandomStringGenerator(indexNumberLength);
        this.indexNumber = generator.generateString();
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
