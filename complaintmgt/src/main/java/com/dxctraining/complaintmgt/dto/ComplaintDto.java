package com.dxctraining.complaintmgt.dto;

public class ComplaintDto {

	private int id;

	private String dsc;
	
	private int consumerid;
	

	public ComplaintDto() {

	}
	
	public ComplaintDto(int consumerid,String dsc) {
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
	
	

}
