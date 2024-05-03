package com.example.Customer.Customer.Request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CustomerAddressRequest implements Serializable {

    private long addressId;
    @NotEmpty(message = "street is Not Empty")
    private String street;

    @Size(min = 3,max = 10,message = "you need to put atlist 3 size of city name ")
    private String city;


    @Size(min = 3,max = 10,message = "you need to put atlist 3 size of state name")
    private String state;

    @Pattern(regexp = "\\d{5}", message = "Postal code must be 5 digits")
    private String postalCode;

    @NotEmpty(message = "Country cannot be empty")
    private String country;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public CustomerAddressRequest() {
    }

    public CustomerAddressRequest(long addressId) {
        this.addressId = addressId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
