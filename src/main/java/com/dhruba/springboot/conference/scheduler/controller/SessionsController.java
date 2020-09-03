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

import com.dhruba.springboot.conference.scheduler.models.Session;
import com.dhruba.springboot.conference.scheduler.repository.SessionRepository;



/**
 * @author dhruba
 * 1) The RestController class is annotated with @RestController
 * 	  By default result controller is going to return 200 as default for success.
 *    If we need something else, we need to annotate method with 
 *    @ResponseStatus(HttpStatus.XXXXXX)
 *    
 * 2) This will have CRUD Operations
 *    C - POST - saveAndFlush()
 *    R - GET - getOne() and findAll()
 *    U - PUT/PATCH for specific - saveAndFlush()
 *    D - DELETE - delete()
 *  
 * 3) The @RequestMapping at the top of class contains BaseURIMapping
 * 4) HTTPS verbs are POST - @PostMapping,GET - @GetMapping,PUT,PATCH,DELETE
 */
/**
 * @author dhruba
 *
 */
@RestController 
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	@Autowired
	private SessionRepository sessionRepository;
	
	
	/**
	 * Read Operation - Read All
	 * HttpVerb - GET
	 * JPA repository finds all records in database and 
	 * Spring MVC returns them to JACKSON which martials them
	 * as a JSON object.
	 * 
	 * @Getmapping is the short hand of RequestMapping which has
	 * RequestMethod as GET
	 */
	@GetMapping
	public List<Session> list() {
		return sessionRepository.findAll(); 
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
	public Session get(@PathVariable Long id) {
		return sessionRepository.getOne(id);
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
	public Session create(@RequestBody final Session session) {
		return sessionRepository.saveAndFlush(session);
	}
	
	/**
	 * 
	 * Delete operation
	 * HttpVerb - DELETE
	 * deleteById() does not delete child records, cascading is needed for that
	 */
	@RequestMapping(value="{id}" , method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionRepository.deleteById(id);
	}
	
	/**
	 * Update Operation
	 * HttpVerb - PUT for update of whole object, PATCH - for specific fields update
	 * 
	 * The 3rd Argument in BeanUtils.copyProperties is foe exclusion of specific field
	 * Here session_id is excluded since it is primary key 
	 */
	@RequestMapping(value="{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		Session exisitingSession = sessionRepository.getOne(id);
		BeanUtils.copyProperties(session, exisitingSession, "session_id");
		return sessionRepository.saveAndFlush(exisitingSession);
	}
}
