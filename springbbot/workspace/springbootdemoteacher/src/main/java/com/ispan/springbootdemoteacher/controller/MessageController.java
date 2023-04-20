package com.ispan.springbootdemoteacher.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ispan.springbootdemoteacher.model.Messages;
import com.ispan.springbootdemoteacher.service.MessageService;

@Controller
public class MessageController {
	
	@Autowired
	private MessageService mService;
	
	@GetMapping("/message/add")
	public ModelAndView addMessage() {
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("messages", new Messages());
		
		Messages latest = mService.getLatest();
		
		mav.addObject("latest", latest);
		
		mav.setViewName("message/addMessagePage");
		
		return mav;
	}
	
	@PostMapping("/messages/post")
	public String postMessage(@ModelAttribute("messages") Messages msg,Model model) {
		mService.addMessage(msg);
		
		model.addAttribute("messages", new Messages());
		
		Messages latest = mService.getLatest();
		model.addAttribute("latest", latest);
		
		return "message/addMessagePage";
	}
	
	@GetMapping("/messages")
	public String goShowMessages(@RequestParam(name="p",defaultValue = "1") Integer pageNumber,Model model) {
		
		Page<Messages> page = mService.findByPage(pageNumber);
		
		model.addAttribute("page", page);
		
		return "message/showMessages";
	}
	
	@GetMapping("/messages/edit")
	public String editPage(@RequestParam("id") Integer id,Model model) {
		Messages msg = mService.findMessagesById(id);
		
		model.addAttribute("messages", msg);
		
		return "message/editMessagePage";
	}
	
	@PutMapping("/messages/edit")
	public String putEditedMessage(@ModelAttribute("messages") Messages msg) {
		mService.updateById(msg.getId(), msg.getText());
		return "redirect:/messages";
	}
	
	@DeleteMapping("/messages/delete")
	public String deleteMessage(@RequestParam Integer id) {
		mService.deleteMessagesById(id);
		return "redirect:/messages";
	}
	
	@ResponseBody
	@PostMapping("/api/messages/post")
	public Page<Messages> postMessageApi(@RequestBody Messages msg){
		mService.addMessage(msg);
		
		Page<Messages> page = mService.findByPage(1);
		
		return page;
	}
	
	@GetMapping("/messages/ajax")
	public String ajaxPage() {
		return "message/ajaxMessage";
	}
	
	

}
