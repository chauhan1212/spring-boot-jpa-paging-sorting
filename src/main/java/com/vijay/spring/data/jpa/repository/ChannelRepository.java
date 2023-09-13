package com.vijay.spring.data.jpa.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vijay.spring.data.jpa.model.Channel;

public interface ChannelRepository extends JpaRepository<Channel, Long> {
  Page<Channel> findByType(String type, Pageable pageable);
  
  Page<Channel> findByModifiedDateBetween(LocalDateTime to, LocalDateTime from, Pageable pageable);

  
  Page<Channel>  findByModifiedGreaterThan(LocalDate dateBefore30Days, Pageable pageable);
}
