package com.blogs.dao;

import java.util.List;

import com.blogs.pojos.Comment;

public interface CommentDao {
//post new comment
	String postNewComment(Comment newComment, Long commenterId, Long postId);

//list all comments by given blog post title
	List<Comment> getCommentsByPost(String next);
}
