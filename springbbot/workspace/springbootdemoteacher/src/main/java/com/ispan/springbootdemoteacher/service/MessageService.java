package com.ispan.springbootdemoteacher.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ispan.springbootdemoteacher.model.Messages;
import com.ispan.springbootdemoteacher.model.MessagesRepository;

@Service
public class MessageService {
	
	@Autowired
	private MessagesRepository msgRepository;
	
	public void addMessage(Messages msg) {
		msgRepository.save(msg);
	}
	
	public Messages findMessagesById(Integer id) {
		Optional<Messages> option = msgRepository.findById(id);
		
		if(option.isEmpty()) {
			return null;
		}
		
		return option.get();
	}
	
	public void deleteMessagesById(Integer id) {
		msgRepository.deleteById(id);
	}
	
	public Page<Messages> findByPage(Integer pageNumber){
		Pageable pgb = PageRequest.of(pageNumber-1, 3, Sort.Direction.DESC, "added");
		Page<Messages> page = msgRepository.findAll(pgb);
		return page;
	}
	
	@Transactional
	public Messages updateById(Integer id, String newMsg) {
		Optional<Messages> option = msgRepository.findById(id);
		
		if(option.isPresent()) {
			Messages msg = option.get();
			msg.setText(newMsg);
			return msg;
		}
		return null;
	}
	
	public Messages getLatest() {
		return msgRepository.findFirstByOrderByAddedDesc();
	}

}
