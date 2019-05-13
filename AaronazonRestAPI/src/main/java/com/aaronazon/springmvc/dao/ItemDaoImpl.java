package com.aaronazon.springmvc.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.aaronazon.springmvc.entity.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	private final static String DELETE_BY_ID_HQL = "delete Item where id = :id";

	@Autowired
	private SessionFactory factory;
	
	public Item saveItem(Item item) {
		Session session = factory.openSession();
		session.save(item);
		return item;
	}

	public List<Item> findAllItems() {
		Criteria criteria = factory.getCurrentSession().createCriteria(Item.class);
		return (List<Item>) criteria.list();
	}

	/**
	 * return success when deleting item by id
	 */
	public int deleteItemById(long id) {
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(DELETE_BY_ID_HQL);
		query.setParameter("id", id);
		int result = query.executeUpdate();
		return result;
	}

	public Item findById(long id) {
		Session session = factory.openSession();
		Item item = session.get(Item.class, id);
		return item;
	}

	public Item updateItem(Item item) {
		Session session = factory.getCurrentSession();
		session.update(item);
		return item;
	}

	public Item findByName(String itemName) {
		Session session = factory.openSession();
		Criteria criteria = session.createCriteria(Item.class);
		criteria.add(Restrictions.eq("itemName", itemName));
		return (Item)criteria.uniqueResult();
	}
	
}