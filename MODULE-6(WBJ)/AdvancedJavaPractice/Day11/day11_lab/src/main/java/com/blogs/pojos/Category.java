package com.blogs.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "categories")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = "blogPosts")
public class Category extends BaseEntity {
	@Column(name = "category_name", unique = true, length = 30)
	private String categoryName;
	private String description;
	// Category 1 ---->* BlogPost (HAS-A : association)
	// Category - one , parent (table) , non owning(inverse) - since it DOES NOT
	// contain FK
	/*
	 * mappedBy : mandatory to specify in a bi dir association Add it in the inverse
	 * side of the association It's value must be = name of the association property 
	 * as it  appears in the owning side
	 */
	@OneToMany(mappedBy = "blogCategory",
			cascade = CascadeType.ALL,orphanRemoval = true
	/* ,fetch = FetchType.EAGER */)
	private List<BlogPost> blogPosts = new ArrayList<>();

	public Category(String categoryName, String description) {
		super();
		this.categoryName = categoryName;
		this.description = description;
	}

//helper method to establish Category 1 <---->* BlogPost
	public void addBlogPost(BlogPost post) {
		this.blogPosts.add(post);// category -> post
		post.setBlogCategory(this);// post -> category
	}

	// helper method to un -establish Category 1 <---->* BlogPost
	public void removeBlogPost(BlogPost post) {
		this.blogPosts.remove(post);
		post.setBlogCategory(null);
	}

}
