package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.pojos.BlogPost;
import com.blogs.pojos.Category;
import com.blogs.pojos.User;
import com.blogs.pojos.UserRole;

public class BlogPostDaoImpl implements BlogPostDao {

	
	@Override
	public String addNewBlog(BlogPost post, Long categoryId, Long bloggerId) {
	    String mesg = "adding blog failed !!!!";
	    // 1. Get Session from SF
	    Session session = getFactory().getCurrentSession();
	    // 2. Begin a Transaction
	    Transaction tx = session.beginTransaction();
	    
	    try {
	        // 3. Validate category - get category details by id
	        Category category = session.get(Category.class, categoryId);  // Use session here
	        // 4. Validate Blogger - get blogger details by its id
	        User blogger = session.get(User.class, bloggerId);  // Use session here
	        
	        // null checking 
	        if (category != null && blogger != null && blogger.getRole() == UserRole.BLOGGER) {
	            // 5. Set up associations: BlogPost -> User (Blogger)
	            post.setBlogger(blogger);
	            // 6. Set up associations: BlogPost -> Category
	            category.addBlogPost(post); // This modifies the Category's blogPost collection
	            
	            // 7. Persist the new blog post via session
	            session.persist(post);  // Session used here to persist the post
	            
	            mesg = "Added new blog post!";
	        } else {
	            mesg = "Category or Blogger is invalid.";
	        }
	        
	        // Commit the transaction (flushes changes)
	        tx.commit();  // Here session is used to commit the transaction
	        
	    } catch (RuntimeException e) {
	        if (tx != null) {
	            tx.rollback();  // Rollback in case of error
	        }
	        throw e;  // Rethrow the exception to be handled by the caller
	    }

	    return mesg;
	}


	@Override
	public String removeBlog(String catName, String postTitle) {
		String mesg = "removing blog failed";
		String jpql1="select c from Category c where c.categoryName=:name";
		String jqpl2="select b from BlogPost b where b.title =:title";

		// 1. get session from SF (getCurrentSession)
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			//3. get category from it's name
			Category category=session.createQuery(jpql1, Category.class)
					.setParameter("name", catName)
					.getSingleResult();
			//4. get blog post form it's title
			BlogPost post=session.createQuery(jqpl2, BlogPost.class)
					.setParameter("title", postTitle)
					.getSingleResult();
			//category , post : persistent
			//de link (or un establish) bi dir association between Category n Post
			category.removeBlogPost(post);
			//how to  de link the uni association between post n blogger ?
			post.setBlogger(null);			
			tx.commit();// DML -
			/*
			 * After adding CascadeType.ALL (delete) + orphanRemoval=true
			 * hibernate will auto delete the orphan record(i.e entity w/o any association)
			 *  , upon commit
			 * 
			 */
			mesg="Removed blog post from the category !";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exc to the caller
			throw e;
		}
		return mesg;
	}

}
