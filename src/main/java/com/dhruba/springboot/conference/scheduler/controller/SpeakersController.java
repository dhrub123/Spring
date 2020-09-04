package com.dhruba.springboot.conference.scheduler.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhruba.springboot.conference.scheduler.models.Speaker;
import com.dhruba.springboot.conference.scheduler.repository.SpeakerRepository;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {

	@Autowired
	private SpeakerRepository speakerRepository;

	/**
	 * Read Operation - Read All
	 * HttpVerb - GET
	 * JPA repository finds all records in database and 
	 * Spring MVC returns them to JACKSON which marshals them
	 * as a JSON object.
	 * 
	 * @Getmapping is the short hand of RequestMapping which has
	 * RequestMethod as GET
	 */
	@GetMapping
	public List<Speaker> list() {
		return speakerRepository.findAll();
	}

	/**
	 * Read Operation - Read by a specific id
	 * HttpVerb - GET
	 * JPA repository finds all records in database and 
	 * Spring MVC returns them to JACKSON which marshals them
	 * as a JSON object.
	 * 
	 * @Getmapping is the short hand of RequestMapping which has
	 * RequestMethod as GET
	 * 
	 * The @PathVariable is used to connect value passed in URI
	 * in a Long variable called id
	 * 
	 * The new URI becomes /api/v1/sessions/3
	 */
	@GetMapping
	@RequestMapping("{id}")
	public Speaker get(@PathVariable Long id) {
		return speakerRepository.getOne(id);
	}

	/**
	 * Create Operation
	 * HttpVerb - POST
	 * 
	 * Spring MVC is taking a JSON request payload and
	 * marshaling it to a session object through @RequestBody 
	 * 
	 * @Postmapping is the short hand of RequestMapping which has
	 * RequestMethod as POST
	 * 
	 * @ResponseStatus(HttpStatus.CREATED) is used to modify
	 * the response code to 201 on success which is 200 
	 * if nothing is mentioned
	 * 
	 * saveAndFlush() saves and commits as one operation
	 * save() does not commit
	 */
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Speaker create(@RequestBody final Speaker speaker) {
		return speakerRepository.saveAndFlush(speaker);
	}

	/**
	 * 
	 * Delete operation
	 * HttpVerb - DELETE
	 * deleteById() does not delete child records, cascading is needed for that
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		speakerRepository.deleteById(id);
	}

	/**
	 * Update Operation
	 * HttpVerb - PUT for update of whole object, PATCH - for specific fields update
	 * 
	 * The 3rd Argument in BeanUtils.copyProperties is foe exclusion of specific field
	 * Here session_id is excluded since it is primary key 
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
		Speaker exisitingSpeaker = speakerRepository.getOne(id);
		BeanUtils.copyProperties(speaker, exisitingSpeaker, "session_id");
		return speakerRepository.saveAndFlush(exisitingSpeaker);
	}
}
