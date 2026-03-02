package com.blogs.entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JPA annotations
@Entity
@Table(name="categories")
//lombok
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,of= {"name","description"})
public class Category extends BaseEntity {
	@Column(length = 100,unique = true)
	private String name;
	private String description;//varchar(255)
	//Category 1--->* BlogPost
	@OneToMany(mappedBy = "blogCategory")
	private List<BlogPost> blogPosts=new ArrayList<>();
	//add overloaded ctor
	public Category(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	

}
