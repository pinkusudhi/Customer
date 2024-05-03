package com.example.Customer.Customer.Responce;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class CustomerResponce implements Serializable {


	public long customerId;

	private String fullName;
	
	
	private String gender;
	
	
	private Date dateOfBirth;
	
	
	private String nationality;
	
	
	private String emailAddress;
	
	
	private String phoneNumber;

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

	public CustomerResponce(long customerId, String fullName, String gender, Date dateOfBirth, String nationality, String emailAddress, String phoneNumber) {
		this.customerId = customerId;
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
	}

	public CustomerResponce() {
	}
}
