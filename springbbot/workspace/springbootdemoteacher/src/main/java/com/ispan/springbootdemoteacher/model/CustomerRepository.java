package com.ispan.springbootdemoteacher.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("from Customer where name = :name")
	public List<Customer> findByCustomerName(@Param(value="name") String name);
	
	@Query(value="select * from customer where name = :name", nativeQuery = true)
	public List<Customer> findByCustomerName2(@Param(value="name") String name);
	
	@Transactional
	@Modifying
	@Query(value="update Customer set name = :n where id = :id")
	public Integer updateNameById(@Param(value="n") String name, @Param(value="id") Integer id);
	
	public List<Customer> findByNameOrderByIdDesc(String name);
}
