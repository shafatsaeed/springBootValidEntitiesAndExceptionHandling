package com.tech.register.model;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.tech.register.validator.Adult;
import com.tech.register.validator.CountrySpecific;

@Document
public class User {
	@Id
	@NotBlank(message = "User Id is mandatory")
	private String userId;
	@NotBlank(message = "First name is mandatory")
	private String firstName;
	private String lastName;
	@Email	
	private String email;
	
	private String address;
	@NotBlank(message = "Password is mandatory")
	private String password;
	
	@NotNull
	@Past
	@Adult(message="Age should be above 18")
	private LocalDate  dateOfBirth;
	
	@NotBlank(message="The country should be France")
	@CountrySpecific
	private String country;
	
	
	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}	
	
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public User() {
		
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}		

}
