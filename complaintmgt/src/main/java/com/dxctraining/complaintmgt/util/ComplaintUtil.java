package com.dxctraining.complaintmgt.util;

import org.springframework.stereotype.Component;

import com.dxctraining.complaintmgt.dto.ComplaintDto;
import com.dxctraining.complaintmgt.entities.Complaint;
@Component
public class ComplaintUtil {

	 public  ComplaintDto complaintDto(Complaint complaint,int consumerId){
		 ComplaintDto complaintDto = new ComplaintDto(complaint.getConsumerid(),complaint.getDsc());
			complaintDto.setConsumerid(consumerId);
			return complaintDto;
	    }

	


}
