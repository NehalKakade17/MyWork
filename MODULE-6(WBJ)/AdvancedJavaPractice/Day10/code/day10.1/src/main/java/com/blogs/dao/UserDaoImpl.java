package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.entities.User;
import com.blogs.entities.UserRole;

public class UserDaoImpl implements UserDao {

	@Override
	public String registerUser(User newUser) {
		// newUser -TRANSIENT (not yet in L1 cache, not in db , exists ONLY in java
		// heap)

		String mesg = "User registration failed !!!!!";
		// 1. Get Session from SessionFactory(SF) - getCurrentSession()
		Session session = getFactory().getCurrentSession();// new
//		Session session2=getFactory().getCurrentSession();//existing
//		System.out.println(session==session2);//true
		// 2. Begin a Transaction
		Transaction tx = session.beginTransaction();
		try {
			// save user info
			// i/p transient entity , o/p - generated id
			Serializable userId = session.save(newUser);
			// newUser -PERSISTENT (added to L1 cache ,not yet in DB)
			// System.out.println(userId.getClass());//java.lang.Long
			// success 3. commit Tx
			tx.commit(); // upon commit
			/*
			 * 1. session.flush() -triggers auto dirty checking (hibernate compares state of
			 * L1 cache with DB) - new entity | updated entity | removed entity -insert |
			 * update | delete (DML) 2. session.close() - L1 cache is destroyed Pooled out
			 * DB connection rets to DBCP , so that the same connection can be reused
			 * further.
			 */
			mesg = "User registered successfully , " + userId;
		} catch (RuntimeException e) {
			// 4. rollback tx
			if (tx != null)
				tx.rollback();// NO DMLs ! , session.close()
			// 5. re throw the same exception to the caller, in case of any problems
			throw e;
		}
		// newUser - is it a part of L1 cache - NO , does it have DB id -YES
		return mesg;
	}

	@Override
	public User getUserDeatils(Long userId) {
		User user = null;// user - does not exist in heap !
		// 1. Get Hibernate Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get user details
			user = session.get(User.class, userId);// select query
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			/*
			 * in case of valid id , user - PERSISTENT - is it a part of L1 cache ? - YES -
			 * does it have the DB id - YES
			 */
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return user;// user - DETACHED from L1 cache
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users = null;
		String jpql = "select u from User u";
		// 1. Get Hibernate Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();
			// users => list of persistent entities
			tx.commit();// session.flush -> auto dirty chking ->no DMLs -> session.close -> L1 destroyed
						// n db cn rets to the pool
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return users;// users : list of detached entities
	}

	@Override
	public List<User> getUserDeatilsByRoleAndDate(UserRole role1, LocalDate date1) {
		List<User> users = null;
		String jpql = "select u from User u where u.role=:rl and u.dob > :date";
		// 1. Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("rl", role1).setParameter("date", date1)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return users;
	}

	@Override
	public List<String> getUserLastNamesByRole(UserRole role1) {
		List<String> lastNames = null;
		String jpql = "select u.lastName from User u where u.role=:role";
		// 1. Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			lastNames = session.createQuery(jpql, String.class).setParameter("role", role1).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return lastNames;
	}

	@Override
	public List<User> testCtorExpression(UserRole role) {
		List<User> users=null;
		String jpql="select new com.blogs.entities.User(firstName,lastName,dob) from User u where u.role=:role";
		// 1. Get Session from SF
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			users=session.createQuery(jpql, User.class)
					.setParameter("role",role)
					.getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}

		return users;
	}

	@Override
	public String changePassword(String email, String oldPwd, String newPwd) {
		String mesg="Updating password failed!!!!";
		String jpql="select u from User u where u.email=:em and u.password=:pass";
		User user=null;
		// 1. Get Session from SF
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			user=session.createQuery(jpql, User.class)
					.setParameter("em", email)
					.setParameter("pass",oldPwd)
					.getSingleResult();
			//=> valid login , rets PERSISTENT entity
			//user : persistent
			user.setPassword(newPwd);//modifying the state of the persistent entity (l1 cache)
			tx.commit();
			mesg="password updated !";
			/*
			 * Hibernate performs auto dirty chking on commit
			 * session.flush() -> DML - update 
			 * session.close()
			 */
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		user.setPassword("999999999");//user - DETACHED - changes NOT done in DB
	
		return mesg;
	}

	@Override
	public String applyDiscount(LocalDate date, double discount) {
		String mesg="Applying discount failed !!!!!";
		// 1. Get Session from SF
		Session session=getFactory().getCurrentSession();
		String jpql="update User u set u.regAmount=u.regAmount-:disc where u.dob < :dt";
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			int updateCount=session.createQuery(jpql)
					.setParameter("disc", discount)
					.setParameter("dt", date)
					.executeUpdate();
			tx.commit();//results in to single update query !
			mesg="Discount applied to "+updateCount+ " no of users....";
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

	@Override
	public String deleteUserDetails(Long userId) {
		String mesg="deletion failed !";
		User user=null;
		// 1. Get Session from SF
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//get user details from it's id
			user=session.get(User.class, userId);
			if(user != null)
			{
				//user : persistent , simply mark it : removed
				session.delete(user);//user : REMOVED
				mesg="user details deleted !";
			}
			tx.commit(); //DML - delete(i.e removed from DB) , L1 cache destroyed
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		//user : TRANSIENT
		return mesg;
	}// user : marked for GC

	@Override
	public String saveImage(String fileName, Long userId) throws IOException{
		String mesg="saving image failed!!!!!";
		// 1. Get Session from SF
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//validate if user exists
			User user=session.get(User.class, userId);
			if(user != null)
			{
				//=> user : PERSISTENT
				//validate if file exists , create java.io.File(String path)
				File file=new File(fileName);
				if(file.isFile() && file.canRead()) {
					//file - existing readable data file
					//use org.apache.commons.io.FileUtils method
					byte[] imgData = FileUtils.readFileToByteArray(file);
					user.setImage(imgData);//modifying the state of persistent entity
					mesg="img saved in DB";
				}
				
			}
			tx.commit();//DML - update !
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}

	@Override
	public String restoreImage(String fileName, Long userId) throws IOException {
		String mesg="restoring image failed";
		// 1. Get Session from SF
		Session session=getFactory().getCurrentSession();
		//2. Begin a Tx
		Transaction tx=session.beginTransaction();
		try {
			//get user details from user id
			User user=session.get(User.class, userId);
			if(user != null)
			{
				//user :persistent
				byte[] imageData = user.getImage();
				if(imageData != null)
				{
					FileUtils.writeByteArrayToFile(new File(fileName), imageData);
					mesg="image data restored !";
				}
				
			}
			tx.commit();
		} catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
	
		return mesg;
	}
	
	
	
	
	
	

}
