package com.ispan.springbootdemo.controller.model;

import java.util.List;

import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {

	@PersistenceContext
	private Session session;
	
	
	public List<Customer> findHouse(String sql) {
		Query<Customer> query = session.createQuery(sql, Customer.class);
		return query.getResultList();
	}
}

