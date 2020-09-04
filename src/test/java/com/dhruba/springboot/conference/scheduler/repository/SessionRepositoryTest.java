package com.dhruba.springboot.conference.scheduler.repository;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhruba.springboot.conference.scheduler.models.Session;

@SpringBootTest
class SessionRepositoryTest {

	@Autowired
	private SessionRepository sessionRepository;

	@Test
	public void testFindSession() {
		Session session = sessionRepository.find(1L);
		assertNotNull(session);
	}

	@Test
	public void saveAndGetAndDelete() {
		Session session = new Session();
		session.setSession_name("Dhrubas session");
		session.setSession_length(25);
		session.setSession_description("Dhruba will take this session");
		sessionRepository.create(session);
		sessionRepository.delete(session.getSession_id());

	}

}
