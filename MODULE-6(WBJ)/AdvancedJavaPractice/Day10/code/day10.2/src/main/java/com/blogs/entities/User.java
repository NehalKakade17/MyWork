package com.blogs.entities;

import java.time.LocalDate;
import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * columns - id , first name , last name, email ,password 
 * , dob , registration amount,role,image
 */
@Entity // mandatory
@Table(name = "users") // to specify table name
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,exclude = {"password","image"})
public class User extends BaseEntity{
//id property MUST be Serializable - typically choose Integer | Long for hibernate mapping purpose
	@Column(name = "first_name", length = 20)
	private String firstName;
	@Column(name = "last_name", length = 20)
	private String lastName;
	@Column(length = 25, unique = true) // unique constraint will be added
	private String email;
	@Column(length = 20, nullable = false) // NOT NULL
	private String password;
	private LocalDate dob;
	@Column(name = "reg_amount")
	private double regAmount;
	@Enumerated(EnumType.STRING)
	@Column(length = 20) // varchar(20)
	private UserRole role;
	@Lob // large objects to be stored in db - def blob type in mysql - longblob
	private byte[] image;

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

	// add overloaded ctor for JPQL ctor expression
	public User(String firstName, String lastName, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
	}

}
