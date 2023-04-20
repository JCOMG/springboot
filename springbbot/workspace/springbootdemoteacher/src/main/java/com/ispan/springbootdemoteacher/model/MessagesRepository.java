package com.ispan.springbootdemoteacher.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessagesRepository extends JpaRepository<Messages, Integer> {

	public Messages findFirstByOrderByAddedDesc();
}
