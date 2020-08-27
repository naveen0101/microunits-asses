package com.dxctraining.consumermgt.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxctraining.consumermgt.dto.ConsumerDto;
import com.dxctraining.consumermgt.dto.CreateConsumerRequest;
import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.service.IConsumerService;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

	@Autowired
	private IConsumerService service;

	@PostMapping("/add")
	public ConsumerDto add(@RequestBody CreateConsumerRequest request) {
		Consumer consumer=new Consumer();
		consumer.setName(request.getName());
		consumer=service.add(consumer);
		ConsumerDto response=toDto(consumer);
		return response;
	}

	

	@GetMapping("/get/{id}")
	public ConsumerDto findConsumerById(@PathVariable("id") int id){
		Consumer consumer=service.findConsumerbyId(id);
		ConsumerDto response=toDto(consumer);
		return response;
	}
	public ConsumerDto toDto(Consumer consumer) {
		ConsumerDto dto=new ConsumerDto();
		dto.setId(consumer.getId());
		dto.setName(consumer.getName());
		return dto;
				
	}
	
	
	

}
