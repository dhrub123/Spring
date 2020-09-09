package com.dhruba.springboot.conference.scheduler.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.dhruba.springboot.conference.scheduler.models.Speaker;
import com.dhruba.springboot.conference.scheduler.repository.SpeakerRepository;

public class SpeakerServiceImpl implements SpeakerService{
	
	@Autowired
	private SpeakerRepository speakerRepository;
	
	@Override
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}
	
	@Override
	public Speaker get(Long id) {
		return speakerRepository.getOne(id);
	}
	
	@Override
	public Speaker create(final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}
	
	@Override
	public void delete(Long id) {
		speakerRepository.deleteById(id);
	}
	
	@Override
	public Speaker update(Long id, Speaker speaker) {
		Speaker exisitingSpeaker = speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, exisitingSpeaker, "session_id");
		return speakerRepository.saveAndFlush(exisitingSpeaker);
	}
}
