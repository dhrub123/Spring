package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dhruba.springboot.conference.scheduler.models.Session;
/**
 * 
 * Employing proxy pattern to redirect to new JPA repository
 * We need @Repository annotation
 * and an injection of the JPARepository
 *
 */
@Repository
public class SessionRepository {

	@Autowired
	private SessionJpaRepository sessionJpaRepository;

	public Session create(Session session) {
		return sessionJpaRepository.saveAndFlush(session);
	}

	public Session update(Long id, Session session) {
		Session sessionToUpdate = sessionJpaRepository.getOne(id);
		BeanUtils.copyProperties(session, sessionToUpdate, "session_id");
		return sessionJpaRepository.saveAndFlush(sessionToUpdate);
	}

	public void delete(Long id) {
		Session sessionToDelete = sessionJpaRepository.getOne(id);
		sessionJpaRepository.delete(sessionToDelete);
	}

	public Session find(Long id) {
		return sessionJpaRepository.getOne(id);
	}

	public List<Session> list() {
		return sessionJpaRepository.findAll();
	}
}
