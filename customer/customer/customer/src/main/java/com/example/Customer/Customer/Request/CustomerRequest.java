package com.example.Customer.Customer.Request;



import jakarta.validation.constraints.*;
import lombok.Data;

import java.io.Serializable;

@Data
public class CustomerRequest implements Serializable {

	@NotEmpty
	@Size(min=4, message = "fullName must be min of 4 character")
	private String fullName;

	@NotEmpty
	@Size (min=4, message = "gender must be min of 4 character")
	private String gender;

	@Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "Date of birth must be in yyyy-MM-dd format")
	private String dateOfBirth;

	@NotEmpty
	@Size(min=4, message = "nationality must be min of 4 character")
	private String nationality;

	@Email(message = "Email addresss is not valid !!")
	private String emailAddress;

	@NotNull
	@Pattern(regexp = "\\d{10}", message = "Phone number must be 10 digits")
	private String phoneNumber;
	

	
	
	public CustomerRequest(String fullName, String gender, String dateOfBirth, String nationality, String emailAddress,
			String phoneNumber) {
		super();
		this.fullName = fullName;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.nationality = nationality;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
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


	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
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


	public CustomerRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}
