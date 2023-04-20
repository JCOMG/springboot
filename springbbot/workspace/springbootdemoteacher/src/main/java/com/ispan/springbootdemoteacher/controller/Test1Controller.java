package com.ispan.springbootdemoteacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ispan.springbootdemoteacher.model.Test1;
import com.ispan.springbootdemoteacher.service.Test1Service;



@Controller
public class Test1Controller {
	
	@Autowired
	private Test1Service t1Service;
	
	

		@GetMapping("/message/test1")
		public String addTest1(Model model) {
			
			model.addAttribute("test1", new Test1());//new Messages是空的物件
			
			
			return "addMessagePage";
		}
	
		public Test1Controller() {
			
		}

}
