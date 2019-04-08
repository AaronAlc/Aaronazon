package com.aaronazon.springmvc.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.aaronazon.springmvc.model.Item;

@Repository("ItemDao")
@Transactional
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SessionFactory factory;
	
	@Override
	public void saveItem(Item item) {
		Session session = factory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.saveOrUpdate(item);
			tx.commit();
		}catch(HibernateException e){
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}	finally {
			session.close();
		}
	}

	@Override
	public List<Item> findAllItems() {

		Session session = factory.openSession();
			
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<Item> criteria = builder.createQuery(Item.class);
		Root<Item> itemRoot = criteria.from(Item.class);
		criteria.select(itemRoot);
		List<Item> items = session.createQuery(criteria).getResultList();
		if(items.size() > 0) {
			session.close();
			return items;
		}
		session.close();
		return null;
	}

	@Override
	public void deleteItemById(long id) {
		Session session = null;
		Transaction tx = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "delete Item where id = :id";
			Query query = session.createQuery(hql);
			query.setParameter("id", id);
			tx.commit();
		}catch(HibernateException e) {
			if (tx != null) tx.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
	}

	@Override
	public Item findById(long id) {
		Session session = factory.openSession();
		Item item = null;
		try {
			item = session.get(Item.class, id);
			Hibernate.initialize(item);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) session.close();
		}
		return item;
	}

	@Override
	public void updateItem(Item item) {
		Session session = factory.openSession();
		session.update(item);
		if(session != null && session.isOpen()) session.close();
	}

	@Override
	public Item findByName(String itemName) {
		Session session = factory.openSession();
		Item item = null;
		try {
			item = session.get(Item.class, itemName);
			Hibernate.initialize(item);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null && session.isOpen()) session.close();
		}
		return item;
	}
	
}
