package com.ispan.springbootdemo.controller.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	
	@Query("from Customer where name = :name")//HQL，這裡的Customer是Entity是對應到Customer.java的public class Customer，Entity事物件想像成是轉運站，可以真正的影響到我們的資料庫
	public List<Customer> findByCustomerName(@Param(value="name") String name);
	
	//原生SQL，就是對應到資料庫而不是Customer.java的public class Customer
	@Query(value="select * from customer where name = :name", nativeQuery = true)
	public List<Customer> findByCustomerName2(@Param(value="name") String name);
	
	//是Integer，因為在資料庫影響了其他的欄位，會跑出影響了幾筆資料，那這些資料不就是整數的方式呈現嗎?(ex:影響了3筆)
	//要更新或刪除要加上@Modifying，在controller要接收前端所傳來的update請求要是PutMapping，PutMapping是拿來更新的
	
	@Transactional//不寫這個會跑出500錯誤，不寫這個會無法做更新或刪除，用來Override JPA Repository的Transactional，因為只能readonly，所以Override掉
	@Modifying//不寫這個會跑出500錯誤，要做select以外的敘述要用@Modifying，就可以做update跟delete的敘述
	@Query(value="update Customer set name = :n where id = :id")
	public Integer updateNameById(@Param(value="n") String name, @Param(value="id") Integer id);
	

}
