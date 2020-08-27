package com.dxctraining.consumermgt.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.dxctraining.consumermgt.entities.Consumer;
import com.dxctraining.consumermgt.exceptions.ConsumerNotFoundException;

@Repository
public class ConsumerDaoImpl implements IConsumerDao {
	@PersistenceContext
	private EntityManager em;

	@Override
	public Consumer add(Consumer consumer) {
		em.persist(consumer);
		return consumer;

	}

	@Override
	public Consumer findConsumerbyId(int id) {

		Consumer consumer = em.find(Consumer.class, id);

		if (consumer == null) {

			throw new ConsumerNotFoundException("consumer not found for id =" + id);

		}
		return consumer;

	}

}
