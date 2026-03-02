package com.blogs.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@MappedSuperclass // represents common base 
//class for all other entities , w/o any table !
@NoArgsConstructor
@Getter
@Setter
@ToString(of = "id")
public class BaseEntity {
	@Id // PK constraint
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto id generation using auto increment
	@Column
	private Long id;
	@CreationTimestamp
	private LocalDate creationDate;
	@UpdateTimestamp
	private LocalDateTime updatedOn;
	//@Version to be added later for optimistic locking !

}
