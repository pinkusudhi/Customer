package com.example.Customer.Customer.Responce;

import java.io.Serializable;

public class CustomerIdentificationResponce implements Serializable {


    private String idType;

    private String idNumber;

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

    public CustomerIdentificationResponce(String idType, String idNumber, String issuingCountry) {
        this.idType = idType;
        this.idNumber = idNumber;
        this.issuingCountry = issuingCountry;
    }

    public CustomerIdentificationResponce() {
    }
}
