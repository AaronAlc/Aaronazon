package com.aaronazon.springmvc.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaronazon.springmvc.model.Login;
import com.aaronazon.springmvc.model.User;

@Repository()
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SessionFactory factory;

	@Override
	public User validateUser(Login login) {
		Session session = factory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("userName", login.getUserName()));
		criteria.add(Restrictions.eq("password", login.getPassword()));
		User user = (User) criteria.uniqueResult();
		return user;
	}

	@Override
	public User registerUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
