package com.blogs.dao;

import com.blogs.pojos.Category;

public interface CategoryDao {
	String addNewCategory(Category category);

	Category getCategoryDetails(String categoryName);

	Category getCategoryAndPostDetails(String categoryName);

	Category getCategoryDetailsById(Long nextLong);
	
}
