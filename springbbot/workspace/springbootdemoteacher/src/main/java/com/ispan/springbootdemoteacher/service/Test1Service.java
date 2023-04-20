package com.ispan.springbootdemoteacher.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ispan.springbootdemoteacher.model.Test1;
import com.ispan.springbootdemoteacher.model.Test1Repository;


@Service
public class Test1Service {

	@Autowired
	private Test1Repository t1Repository;
	
	
	public void addTest1(Test1 id) {
		t1Repository.save(id);//新增單筆的進入資料庫

	}

}
