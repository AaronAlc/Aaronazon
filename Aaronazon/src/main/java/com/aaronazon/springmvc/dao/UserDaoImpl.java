package com.aaronazon.springmvc.dao;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

@Repository("UserDao")
@Transactional
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public User validateUser(Login login) {
		Session session = null;
		try {
			session = factory.openSession();
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.where(
				builder.equal(root.get("userName"), login.getUserName()),
				builder.equal(root.get("password"), login.getPassword()));
			User user = session.createQuery(query).getSingleResult();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) session.close();
		}
		return null;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

}
