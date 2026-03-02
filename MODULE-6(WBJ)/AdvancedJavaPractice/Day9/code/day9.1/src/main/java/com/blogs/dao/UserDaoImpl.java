package com.blogs.dao;

import static com.blogs.utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.blogs.entities.User;

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
		User user = null;//user - does not exist in heap !
		// 1. Get Hibernate Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin a Tx
		Transaction tx = session.beginTransaction();
		try {
			// get user details
			user = session.get(User.class, userId);//select query
			user = session.get(User.class, userId);
			user = session.get(User.class, userId);
			/*in case of valid id , user - PERSISTENT 
			 * - is it a part of L1 cache ? - YES
			 * - does it have the DB id - YES
			 */
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the same exception to the caller
			throw e;
		}
		return user;//user - DETACHED from L1 cache
	}

	@Override
	public List<User> getAllUserDetails() {
		List<User> users=null;
		String jpql="select u from User u";
		// 1. Get Hibernate Session from SessionFactory
				Session session=getFactory().getCurrentSession();
				//2. Begin a Tx
				Transaction tx=session.beginTransaction();
				try {
					users=session.createQuery(jpql,User.class)
							.getResultList();
					tx.commit();
				} catch (RuntimeException e) {
					if(tx != null)
						tx.rollback();
					//re throw the same exception to the caller
					throw e;
				}
		return users;
	}
	

}
