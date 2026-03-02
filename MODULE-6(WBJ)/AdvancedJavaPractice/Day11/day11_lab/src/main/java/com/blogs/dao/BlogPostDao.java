package com.blogs.dao;

import com.blogs.pojos.BlogPost;

public interface BlogPostDao {
//add a method to add new blog to existing category
	String addNewBlog(BlogPost post,Long categoryId, Long bloggerId);
	//add a method to remove a blogfrom specified category
	String removeBlog(String catName, String postTitle);
}
