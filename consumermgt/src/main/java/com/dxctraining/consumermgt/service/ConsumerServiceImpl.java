package com.dxctraining.consumermgt.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxctraining.consumermgt.dao.IConsumerDao;
import com.dxctraining.consumermgt.entities.Consumer;

@Transactional
@Service
public class ConsumerServiceImpl implements IConsumerService {
	@Autowired
	private IConsumerDao dao;

	@Override
	public Consumer add(Consumer consumer) {

		dao.add(consumer);

		return consumer;

	}

	@Override
	public Consumer findConsumerbyId(int id) {
		Consumer consumer = dao.findConsumerbyId(id);
		return consumer;

	}

}
