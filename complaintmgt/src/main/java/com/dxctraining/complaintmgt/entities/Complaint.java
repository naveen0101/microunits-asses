package com.dxctraining.complaintmgt.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Entity

public class Complaint {
	@Id
	@GeneratedValue
	private int id;

	private String dsc;
	
	private int consumerid;

	public Complaint() {

	}

	public Complaint(String dsc,int consumerid) {
		this.dsc = dsc;
		this.consumerid=consumerid;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDsc() {
		return dsc;
	}

	public void setDsc(String dsc) {
		this.dsc = dsc;
	}
	
	
	public int getConsumerid() {
		return consumerid;
	}

	public void setConsumerid(int consumerid) {
		this.consumerid = consumerid;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Complaint that = (Complaint) obj;
		return id == that.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	

}
