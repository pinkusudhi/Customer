package com.example.Customer.Customer.Request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;

public class CustomerIdentificationRequest implements Serializable {

    @NotBlank(message = "ID type must not be blank")
    @Size(max = 255, message = "ID type must be at most 255 characters")
    private String idType;

    @NotBlank(message = "ID number must not be blank")
    @Size(max = 255, message = "ID number must be at most 255 characters")
    private String idNumber;

    @NotBlank(message = "Issuing country must not be blank")
    @Size(max = 255, message = "Issuing country must be at most 255 characters")
    private String issuingCountry;

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getIssuingCountry() {
        return issuingCountry;
    }

    public void setIssuingCountry(String issuingCountry) {
        this.issuingCountry = issuingCountry;
    }

    public CustomerIdentificationRequest(String idType, String idNumber, String issuingCountry) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.issuingCountry = issuingCountry;
    }

    public CustomerIdentificationRequest() {
    }
}
