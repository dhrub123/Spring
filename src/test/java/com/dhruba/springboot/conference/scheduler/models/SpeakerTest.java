package com.dhruba.springboot.conference.scheduler.models;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhruba.springboot.conference.scheduler.repository.SpeakerRepository;

@SpringBootTest
class SpeakerTest {

	@Autowired
	private SpeakerRepository speakerRepository;

	@Test
	public void testFind() {
		Speaker speaker = speakerRepository.getOne(1l);
		assertNotNull(speaker);
	}

	@Test
	public void saveAndGetAndDelete() {
		Speaker speaker = new Speaker();
		speaker.setCompany("Pluralsight");
		speaker.setFirstName("Dhruba");
		speaker.setLastName("Nag");
		speaker.setTitle("Author");
		speaker.setSpeakerBio("Consulting and mentoring");
		speaker = speakerRepository.saveAndFlush(speaker);

		Speaker speakerToDelete = speakerRepository.getOne(speaker.getSpeakerId());
		speakerRepository.deleteById(speakerToDelete.getSpeakerId());
	}

	@Test
	public void testJpaAnd() {
		List<Speaker> speakers = speakerRepository.findByFirstNameAndLastName("Justin", "Clark");
		assertTrue(speakers.size() > 0);
	}

	@Test
	public void testJpaOr() {
		List<Speaker> speakers = speakerRepository.findByFirstNameOrLastName("Justin", "Clark");
		assertTrue(speakers.size() > 0);
	}
	
	@Test
	public void testNull() {
		List<Speaker> speakers = speakerRepository.findBySpeakerPhotoNull();
		assertTrue(speakers.size() > 0);
	}
	
	@Test
	public void testInNotInIgnoreCase() {
		
		List<String> companies = new ArrayList<String>();
		companies.add("Contoso");
		companies.add("Fabrikam Industries");
		
		List<Speaker> speakers = speakerRepository.findByCompanyIn(companies);
		assertTrue(speakers.size() > 0);
		
		speakers = speakerRepository.findByCompanyNotIn(companies);
		assertTrue(speakers.size() > 0);
		
		speakers = speakerRepository.findByCompanyIgnoreCase("contoso");
		assertTrue(speakers.size() > 0);
	}
	
	@Test
	public void testOrderBy() {
		
		List<Speaker> speakers = speakerRepository.findByFirstNameOrderByLastNameAsc("Andrew");
		assertTrue(speakers.size() > 0);
		
		speakers = speakerRepository.findByFirstNameOrderByLastNameDesc("Andrew");
		assertTrue(speakers.size() > 0);
	}
	
	@Test
	public void firstTopDistinct() {
		Speaker speaker = speakerRepository.findFirstByFirstName("Andrew");
		assertNotNull(speaker);
		
		List<Speaker> speakers = speakerRepository.findTop5ByFirstName("Andrew");
		assertTrue(speakers.size() > 0);
		
		speakers = speakerRepository.findDistinctByFirstName("Andrew");
		assertTrue(speakers.size() > 0);
	}

}
