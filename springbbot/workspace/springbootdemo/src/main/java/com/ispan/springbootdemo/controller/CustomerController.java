package com.ispan.springbootdemo.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ispan.springbootdemo.controller.model.Customer;
import com.ispan.springbootdemo.controller.model.CustomerRepository;

@RestController
public class CustomerController {
	@Autowired
	private CustomerRepository customerRepository;

	@PostMapping("/customer/add")
	public Customer addOneCustomer() {
		Customer cus1 = new Customer();
		cus1.setName("館長");
		cus1.setLevel(5);
		Customer resCustomer = customerRepository.save(cus1);
		return resCustomer;
	}

	@PostMapping("/customer/add2")
	public Customer addOneCustomer2(@RequestBody Customer cus) {
		Customer resCustomer = customerRepository.save(cus);
		return resCustomer;
	}

	@PostMapping("/customer/addsomecustomer")
	public List<Customer> addSomeCustomer(@RequestBody List<Customer> customers) {
		List<Customer> resCustomers = customerRepository.saveAll(customers);
		return resCustomers;

	}

	@GetMapping("/customer/{id}")
	public Customer findCustomerById(@PathVariable Integer id) {
		Optional<Customer> option = customerRepository.findById(id);

		if (option.isPresent()) {
			Customer result = option.get();
			return result;
		}

		return null;
	}

	@GetMapping("/customer")
	public List<Customer> findAllCustomer() {// 因為finAll有順序，所以用List，無順序的就用Set
		List<Customer> findAll = customerRepository.findAll();
		return findAll;

	}

	@DeleteMapping("/customer/delete")
	public String deleCustomerById(@RequestParam (name="id") Integer id) {
		try {
			customerRepository.deleteById(id);
			return"刪除成功";
		} catch (EmptyResultDataAccessException e) {

		return "沒有這筆資料";
				
		}
	}
	
	@GetMapping("/customer/page")
	public List<Customer> findByPage(@RequestParam("p") Integer pageNumber){//Integer pageNumber一開始會是1，可是在做page的時候第0頁才是第1頁
		Pageable pgb = PageRequest.of(pageNumber-1, 3 , Sort.Direction.ASC , "id");
		Page<Customer> page = customerRepository.findAll(pgb);
		return page.getContent();
	}
	
	@GetMapping("/customer/name")
	public List<Customer> findCustomerByName(@RequestParam("name") String name){
		return customerRepository.findByCustomerName(name);

}
	@GetMapping("/customer/name2")
	public List<Customer> findCustomerByName2(@RequestParam("name") String name){
		return customerRepository.findByCustomerName2(name);
		
	}
	
	
	@PutMapping("/customer/update")//單筆修改用這個方法
	public String updateCustomerName(
			@RequestParam(name="id") Integer id, 
			@RequestParam(name="newName") String newName) {
		Integer result = customerRepository.updateNameById(newName, id);
		
		if(result > 0) {
			return "修改成功";
		}
		
		return "沒有這筆資料，修改失敗";
	}
	
	@GetMapping("/customer/name3")
    public String findHouse(@RequestParam String region,
    		@RequestParam String type,
    		@RequestParam String price,
    		@RequestParam String room,
    		@RequestParam String feature) {
		
		String hql = "from House where ";
		
		if(region!=null) {
			hql += "region = "+ region;
		}
		
		if(type!=null) {
			hql += "type = "+ type;
		}
		
		if(region!=null) {
			hql += "region = "+ region;
		}
		
		if(region!=null) {
			hql += "region = "+ region;
		}
		
		return "";
	}
	
	
}
