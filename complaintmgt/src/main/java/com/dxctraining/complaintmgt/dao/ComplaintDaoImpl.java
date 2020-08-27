package com.dxctraining.complaintmgt.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.dxctraining.complaintmgt.entities.Complaint;
import com.dxctraining.complaintmgt.exceptions.ComplaintNotFoundException;

@Repository
public class ComplaintDaoImpl implements IComplaintDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Complaint add(Complaint complaint) {

		em.persist(complaint);

		return complaint;

	}

	@Override
	public Complaint findComplaintById(int id) {
		Complaint complaint = em.find(Complaint.class, id);

		if (complaint == null) {
			throw new ComplaintNotFoundException("complaint not found for id =" + id);

		}
		return complaint;

	}
	
	@Override
	public List<Complaint> allComplaintsByConsumer(int consumerid) {
		String jpaql = "from Complaint where consumerId=:consumer";
		TypedQuery<Complaint> query = em.createQuery(jpaql, Complaint.class);
		query.setParameter("consumer", consumerid);
		List<Complaint> complaintList = query.getResultList();
		return complaintList;
	}

}
