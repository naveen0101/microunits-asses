package com.dxctraining.complaintmgt.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.complaintmgt.dao.IComplaintDao;
import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.InvalidArgumentException;

@Service
@Transactional
public class ComplaintServiceImpl implements IComplaintService {

	@Autowired
	private IComplaintDao dao;

	@Override
	public Complaint add(Complaint complaint) {
		validate(complaint);
		dao.add(complaint);

		return complaint;

	}

	private void validate(Object obj) {
		if (obj == null) {
			throw new InvalidArgumentException("Argument is null");
		}
	}

	@Override
	public Complaint findComplaintById(int id) {
		validate(id);

		Complaint complaint = dao.findComplaintById(id);

		return complaint;

	}
	
	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerid) {
		List<Complaint> list = dao.allComplaintsByConsumer(consumerid);
		return list;
	}

}
