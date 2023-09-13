package com.vijay.spring.data.jpa.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.spring.data.jpa.model.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long> {
	  Page<Topic> findByTitle(String type, Pageable pageable);
	}
