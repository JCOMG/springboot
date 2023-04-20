package com.ispan.springbootdemoteacher.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	// 抓原本 Hibernate 的 Session
	@PersistenceContext
	private Session session;
	
	
	public List<Customer> findHouse(String hql) {
		Query<Customer> query = session.createQuery(hql, Customer.class);
		return query.getResultList();
	}
}
