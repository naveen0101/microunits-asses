package com.dxctraining.consumermgt.dao;

import com.dxctraining.consumermgt.entities.Consumer;

public interface IConsumerDao {
	
	
	Consumer add(Consumer consumer);
	
	Consumer findConsumerbyId(int id);
	

	
}
