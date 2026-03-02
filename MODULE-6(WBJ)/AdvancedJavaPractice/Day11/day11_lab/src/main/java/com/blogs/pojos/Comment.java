package com.blogs.pojos;

import javax.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "comments")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper = true, of = {"commentText", "rating"})
public class Comment extends BaseEntity {

    @Column(name = "comment_text", length = 100)
    private String commentText;

    private int rating;

    // Many-to-One relationship: A Comment is associated with one User (commenter)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commenter_id", nullable = false)  // Assuming the column name is commenter_id
    private User commenter;

    // Many-to-One relationship: A Comment is associated with one Post
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", nullable = false)  // Assuming the column name is post_id
    private BlogPost post;

    // Constructor to set comment text and rating
    public Comment(String commentText, int rating) {
        super();
        this.commentText = commentText;
        this.rating = rating;
    }
}



