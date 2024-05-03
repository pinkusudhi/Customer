package com.example.Customer.Customer.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "customer_identification")
@Data
public class CustomerIdentificationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "identification_id")
    private long identificationId;

    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_number")
    private String idNumber;

    @Column(name = "issuing_country")
    private String issuingCountry;

    @OneToOne
    private CustomerEntity customerEntity;

    public long getIdentificationId() {
        return identificationId;
    }

    public void setIdentificationId(long identificationId) {
        this.identificationId = identificationId;
    }

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

    public CustomerEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(CustomerEntity customerEntity) {
        this.customerEntity = customerEntity;
    }

    public CustomerIdentificationEntity(long identificationId, String idType, String idNumber, String issuingCountry, CustomerEntity customerEntity) {
        this.identificationId = identificationId;
        this.idType = idType;
        this.idNumber = idNumber;
        this.issuingCountry = issuingCountry;
        this.customerEntity = customerEntity;
    }

    public CustomerIdentificationEntity() {
    }
}
