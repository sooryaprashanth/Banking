package com.practise.banking.DTO;

public class Address {
    private String Street;
    private String City;
    private String State;
    private long postalcode;

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

    public long getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(long postalcode) {
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
