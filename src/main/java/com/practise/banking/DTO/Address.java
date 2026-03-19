package com.practise.banking.DTO;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
    private String Street;
    private String City;
    private String State;
    private String postalcode;

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "Street='" + Street + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", postalcode=" + postalcode +
                '}';
    }
}
