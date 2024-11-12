package org.example.Task20;

public class QueuePerson {
    private String lastName;
    private String firstName;
    private String middleName;
    private AddressValue address;
    private int priority;

    public QueuePerson(String lastName, String firstName, String middleName, AddressValue address, int priority) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.address = address;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public String getLastName(){
        return lastName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + middleName + ", Address: " + address + ", Priority: " + priority;
    }
}

