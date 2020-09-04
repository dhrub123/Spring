package com.dhruba.springboot.conference.scheduler.repository;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.dhruba.springboot.conference.scheduler.models.Session;

@SpringBootTest
class SessionRepositoryTest {

	@Autowired
	private SessionRepository sessionRepository;
	
	@Autowired
	private SessionJpaRepository sessionJpaRepository;

	@Test
	public void testFindSession() {
		Session session = sessionRepository.find(1L);
		assertNotNull(session);
	}

	@Test
	public void testSaveAndGetAndDelete() {
		Session session = new Session();
		session.setSessionName("Dhrubas session");
		session.setSessionLength(25);
		session.setSessionDescription("Dhruba will take this session");
		sessionRepository.create(session);
		sessionRepository.delete(session.getSessionId());

	}
	
	@Test
	public void testGetSessionsThatHaveName() {
		List<Session> sessions = sessionRepository.getSessionsThatHaveName("Java");
		assertTrue(sessions.size()>0);
	}
	
	@Test
	public void testEqualsNotEquals() {
		List<Session> sessions = sessionJpaRepository.findBySessionLength(30);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthIs(30);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthEquals(30);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthNot(30);
		assertTrue(sessions.size() > 0);

	}
	
	@Test
	public void testLikeNotLike() {
		List<Session> sessions = sessionJpaRepository.findBySessionNameLike("Selling%");
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionNameNotLike("Python%");
		assertTrue(sessions.size() > 0);
	}
	
	@Test
	public void testStartingWithEndingWithContaining() {
		List<Session> sessions = sessionJpaRepository.findBySessionNameStartingWith("Spring");
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionNameEndingWith("Java");
		assertTrue(sessions.size() > 0);
		
		sessions = sessionJpaRepository.findBySessionNameContaining("Principles");
		assertTrue(sessions.size() > 0);
	}
	
	@Test
	public void testLessThanGreaterThan() {
		List<Session> sessions = sessionJpaRepository.findBySessionLengthLessThan(45);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthLessThanEqual(45);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthGreaterThan(45);
		assertTrue(sessions.size() > 0);

		sessions = sessionJpaRepository.findBySessionLengthGreaterThanEqual(45);
		assertTrue(sessions.size() > 0);

	}
	
	@Test
	public void testPagingAndSorting() {
		Page<Session> page = sessionJpaRepository.getSessionsWithName(
				"S", //Sessions with s in the beginning of their title 
				PageRequest.of(
						1, //1 page
						5, //Each page can have 5 results
						Sort.by(
								Sort.Direction.DESC, // Sort descending by session length
								"sessionLength"
								)
						)
		);
		assertTrue(page.getTotalElements() > 0);
	}
	
	@Test
	public void testCustomRepositoryImpl() {
		List<Session> sessions = sessionJpaRepository.customGetSessions();
		assertTrue(sessions.size() > 0);
	}

}
