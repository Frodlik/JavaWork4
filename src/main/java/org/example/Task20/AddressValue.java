package org.example.Task20;

public class AddressValue {
    private String city;
    private String street;
    private String houseNumber;
    private int apartmentNumber;

    public AddressValue(String city, String street, String houseNumber, int apartmentNumber) {
        this.city = city;
        this.street = street;
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return city + ", " + street + " St., House No. " + houseNumber +
                (apartmentNumber > 0 ? ", Apartment No. " + apartmentNumber : "");
    }
}

