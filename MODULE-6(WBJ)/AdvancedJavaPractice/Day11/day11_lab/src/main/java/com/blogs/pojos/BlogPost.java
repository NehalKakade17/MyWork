package com.blogs.pojos;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.util.List;

@Entity
@Table(name = "posts")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, exclude = {"blogCategory", "blogger", "comments"})
public class BlogPost extends BaseEntity {

    @Column(unique = true, length = 100)
    private String title;

    private String description;

    @Column(length = 1000)
    private String content;

    // BlogPost * -----> 1 Category
    @ManyToOne(fetch = FetchType.LAZY) // mandatory, otherwise MappingException
    @JoinColumn(name = "category_id", nullable = false) // customize name of FK column + added NOT NULL constraint
    private Category blogCategory;

    // BlogPost * ---> 1 User (Blogger)
    @ManyToOne(fetch = FetchType.LAZY) // mandatory, otherwise MappingException
    @JoinColumn(nullable = false)
    private User blogger;

    @Column(nullable = false)
    private Boolean available = true;

    // One-to-many relationship between BlogPost and Comment
    @OneToMany(mappedBy = "post", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Comment> comments;

    // Constructor
    public BlogPost(String title, String description, String content) {
        super();
        this.title = title;
        this.description = description;
        this.content = content;
        this.available = true;
    }
}

