package com.dhruba.springboot.conference.scheduler.models;

import static org.junit.Assert.assertNotNull;

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
		speaker.setFirst_name("Dhruba");
		speaker.setLast_name("Nag");
		speaker.setTitle("Author");
		speaker.setSpeaker_bio("Consulting and mentoring");
		speaker = speakerRepository.saveAndFlush(speaker);

		Speaker speakerToDelete = speakerRepository.getOne(speaker.getSpeaker_id());
		speakerRepository.deleteById(speakerToDelete.getSpeaker_id());
	}

}
