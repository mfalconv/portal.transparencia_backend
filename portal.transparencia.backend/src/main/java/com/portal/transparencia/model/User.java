package com.portal.transparencia.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "email", length = 60, unique = true, nullable = false)
	private String email;

	@Column(name = "password", length = 60, nullable = false)
	private String password;

	@Column(name = "role", length = 20)
	private String role;

	@Column(name = "purchaseDate", nullable=false)
	private LocalDate purchaseDate;
	
	@Column(name="parcel_number", nullable = true, unique=true, length=50)
	private String parcelNumber; 
	
	@Column(name="payment", nullable=true, length=20)
	private String payment; 
	
	@Column(name="sign", nullable = false)
	private Boolean sign; 
	
	

	public User() {
		super();
	}



	public User(Long id, String email, String password, String role, LocalDate purchaseDate, String parcelNumber,
			String payment, Boolean sign) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.role = role;
		this.purchaseDate = purchaseDate;
		this.parcelNumber = parcelNumber;
		this.payment = payment;
		this.sign = sign;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}



	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}



	public String getParcelNumber() {
		return parcelNumber;
	}



	public void setParcelNumber(String parcelNumber) {
		this.parcelNumber = parcelNumber;
	}



	public String getPayment() {
		return payment;
	}



	public void setPayment(String payment) {
		this.payment = payment;
	}



	public Boolean getSign() {
		return sign;
	}



	public void setSign(Boolean sign) {
		this.sign = sign;
	}

	

}