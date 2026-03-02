package com.blogs.entities;

import java.time.LocalDate;
import javax.persistence.*;
/*
 * columns - id , first name , last name, email ,password 
 * , dob , registration amount,role,image
 */
@Entity //mandatory
@Table(name="users")//to specify table name
public class User {
//id property MUST be Serializable - typically choose Integer | Long for hibernate mapping purpose
	@Id //PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) //auto id generation using auto increment
	@Column(name="user_id")
	private Long userId;
	@Column(name="first_name",length = 20)
	private String firstName;
	@Column(name="last_name",length = 20)
	private String lastName;
	@Column(length = 25,unique = true)//unique constraint will be added
	private String email;
	@Column(length = 20,nullable = false)//NOT NULL 
	private String password;
//	@Transient //skip col generation
//	private String confirmPassword;
	private LocalDate dob;
	@Column(name="reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)//varchar(20)
	private UserRole role;
	@Lob //large objects to be stored in db - def blob type in mysql - longblob
	private byte[] image;
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String firstName, String lastName, String email, String password, LocalDate dob, double regAmount,
			UserRole role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.dob = dob;
		this.regAmount = regAmount;
		this.role = role;
	}

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public double getRegAmount() {
		return regAmount;
	}
	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	public UserRole getRole() {
		return role;
	}
	public void setRole(UserRole role) {
		this.role = role;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", dob=" + dob + ", regAmount=" + regAmount + ", role=" + role + "]";
	}	
	
}
