package com.example.Customer.Customer.Entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Entity
@Data
@Table(name="Customer")
@Getter
@Setter
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="customer_id")
	private long customerId;
	
	@Column(name="full_name")
	private String fullName;
	
	@Column(name="gender")
	private String gender;
	
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="nationality")
	private String nationality;
	
	@Column(name="email_address")
	private String emailAddress;
	
	@Column(name="Phone_number")
	private String phoneNumber;
	
	@OneToMany(mappedBy = "customerEntity")
	private List<CustomerAddressEntity> addressEntity = new ArrayList();
	
	@OneToOne(mappedBy = "customerEntity")
	private CustomerIdentificationEntity customerIdentificationEntity;
	
	public long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public List<CustomerAddressEntity> getAddressEntity() {
		return addressEntity;
	}

	public void setAddressEntity(List<CustomerAddressEntity> addressEntity) {
		this.addressEntity = addressEntity;
	}

	public CustomerIdentificationEntity getCustomerIdentificationEntity() {
		return customerIdentificationEntity;
	}

	public void setCustomerIdentificationEntity(CustomerIdentificationEntity customerIdentificationEntity) {
		this.customerIdentificationEntity = customerIdentificationEntity;
	}

	public CustomerEntity(long customerId, String fullName, String gender, Date dateOfBirth, String nationality,
			String emailAddress, String phoneNumber, List<CustomerAddressEntity> addressEntity,
			CustomerIdentificationEntity customerIdentificationEntity) {
		super();
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.addressEntity = addressEntity;
		this.customerIdentificationEntity = customerIdentificationEntity;
	}

	public CustomerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
