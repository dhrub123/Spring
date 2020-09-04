package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.dhruba.springboot.conference.scheduler.models.Session;

public class SessionCustomJpaRepositoryImpl implements SessionCustomJpaRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Session> customGetSessions() {
		return entityManager.createQuery("select s from Session s").getResultList();
	}

}
