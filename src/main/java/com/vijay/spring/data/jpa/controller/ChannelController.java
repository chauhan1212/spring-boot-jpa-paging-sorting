package com.vijay.spring.data.jpa.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vijay.spring.data.jpa.model.Channel;
import com.vijay.spring.data.jpa.repository.ChannelRepository;

@RestController
@RequestMapping("/api")
public class ChannelController {

	@Autowired
	ChannelRepository channelRepository;

	@GetMapping("/channels/{type}")
	public ResponseEntity<Page<Channel>> findByPublished(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "3") int size,
			@RequestParam(defaultValue = "2023-08-20") @DateTimeFormat(pattern = "yyyy-MM-dd") Date fromDate,
			@RequestParam(defaultValue = "2023-09-23") @DateTimeFormat(pattern = "yyyy-MM-dd") Date toDate,
			@PathVariable("type") String type) {

		try {
			List<Channel> tutorials = new ArrayList<>();
			Pageable paging = PageRequest.of(page, size);

			LocalDateTime ldt = LocalDateTime.ofInstant(fromDate.toInstant(), ZoneId.systemDefault());
			LocalDateTime ldt2 = LocalDateTime.ofInstant(toDate.toInstant(), ZoneId.systemDefault());

//      Page<Channel> pageTuts2 = channelRepository.findByModifiedDateBetween(ldt2, ldt, paging);

			LocalDate dateBefore30Days = LocalDate.now().minusDays(30);
			// Page<Channel> pageTuts4 =
			// channelRepository.findByModifiedGreaterThan(dateBefore30Days, paging);

			Page<Channel> pageTuts = channelRepository.findByType(type, paging);
			tutorials = pageTuts.getContent();

			Map<String, Object> response = new HashMap<>();
			response.put("tutorials", tutorials);
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());

			return new ResponseEntity<>(pageTuts, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();

			// return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return null;
	}

	@PostMapping("/channels")
	public ResponseEntity<Channel> createTutorial(@RequestBody Channel tutorial) {
		try {
			Channel _tutorial = channelRepository.save(tutorial);

			System.out.println("Chnnel : " + tutorial);

			System.out.println("ddd : " + _tutorial);
			return new ResponseEntity<>(_tutorial, HttpStatus.CREATED);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
