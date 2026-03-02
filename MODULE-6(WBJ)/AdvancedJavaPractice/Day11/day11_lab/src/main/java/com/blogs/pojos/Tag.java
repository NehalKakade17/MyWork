package com.blogs.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "tags")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, of = "name")
public class Tag extends BaseEntity {
	@Column(length = 20, unique = true)
	private String name;

	public Tag(String name) {
		super();
		this.name = name;
	}

}
