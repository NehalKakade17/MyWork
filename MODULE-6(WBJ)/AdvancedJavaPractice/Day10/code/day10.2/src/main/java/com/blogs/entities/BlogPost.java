package com.blogs.entities;
import javax.persistence.FetchType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JPA annotations
@Entity
@Table(name="posts")
//lombok
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true,of= {"title","description"})
public class BlogPost extends BaseEntity {
	
	@Column(length = 100,unique = true)
	private String title;
	private String description;
	@Column(length = 1000)
	private String contents;
	//BlogPost *-->1 Category 
	@ManyToOne(fetch = FetchType.LAZY) // Using FetchType.LAZY for lazy loading (optional, but often recommended)
    @JoinColumn(name = "blogCategory")
	private Category blogCategory;
	//add overloaded ctor
	public BlogPost(String title, String description, String contents) {
		super();
		this.title = title;
		this.description = description;
		this.contents = contents;
	}
	
	
	

}
