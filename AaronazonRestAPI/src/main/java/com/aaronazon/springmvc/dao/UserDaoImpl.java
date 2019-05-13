package com.aaronazon.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaronazon.springmvc.entity.User;

@Repository()
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public User validateUser(User user) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", user.getUserName()));
		criteria.add(Restrictions.eq("password", user.getPassword()));
		user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public User registerUser(User user) {
		Session session = factory.getCurrentSession();
		session.save(user);
		return user;
	}


}
