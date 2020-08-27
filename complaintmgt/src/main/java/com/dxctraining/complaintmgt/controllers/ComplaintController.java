package com.dxctraining.complaintmgt.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.dto.ConsumerRequest;
import com.dxctraining.complaintmgt.dto.CreateComplaintRequest;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.service.IComplaintService;
import com.dxctraining.complaintmgt.util.ComplaintUtil;

@RestController
@RequestMapping("/complaint")
public class ComplaintController {

	@Autowired
	private IComplaintService service;

	@Autowired
	private ComplaintUtil complaintutil;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add")
	public ComplaintDto create(@RequestBody CreateComplaintRequest requestData) {

		String dsc = requestData.getDsc();
		int consumerid = requestData.getId();
		Complaint complaint = new Complaint(dsc, consumerid);
		complaint = service.add(complaint);
		
		ComplaintDto response = complaintutil.complaintDto(complaint, consumerid);
		return response;

	}

	private ConsumerRequest fetchByConsumerId(int consumerid) {
		String url = "http://localhost:8587/consumer/get/" + consumerid;
		ConsumerRequest request = restTemplate.getForObject(url, ConsumerRequest.class);
		return request;
	}

	@GetMapping("/get/{id}")
	public ComplaintDto getComplaint(@PathVariable("id") int id) {
		Complaint complaint = service.findComplaintById(id);
		int consumerid = complaint.getConsumerid();
		fetchByConsumerId(consumerid);
		ComplaintDto response = complaintutil.complaintDto(complaint, consumerid);
		return response;
	}

	@GetMapping("/consumer/{consumerId}")
	public List<ComplaintDto> fetchAllComplaints(@PathVariable("consumerid") int consumerid) {
		List<Complaint> list = service.allComplaintsByConsumer(consumerid);
		List<ComplaintDto> response = new ArrayList<>();
		fetchByConsumerId(consumerid);
		for (Complaint complaint : list) {
			ComplaintDto complaintDto = complaintutil.complaintDto(complaint, consumerid);
			response.add(complaintDto);
		}
		return response;
	}
	
}
