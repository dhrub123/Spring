package com.dhruba.springboot.conference.scheduler.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dhruba.springboot.conference.scheduler.models.Session;
import com.dhruba.springboot.conference.scheduler.repository.SessionRepository;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {

	/* Metric related code below

	private Timer timer;

	public SessionsController(MeterRegistry registry) {
		timer = registry.timer("long.running.op.timer");
	}

	// Then in long running method add following code
	public void longRunningMethod() {
		timer.record(() -> {
			// long running opearation code here
		});
	}

	// Metric related code ends */
	
	@Autowired
	private SessionRepository sessionRepository;

	/**
	 * Now URL can be http://localhost:5000/api/v1/sessions?name=Java or
	 * http://localhost:5000/api/v1/sessions
	 */
	@GetMapping
	public List<Session> list(@RequestParam(required = false) String name) {
		if (name != null) {
			return sessionRepository.getSessionsThatHaveName(name);
		} else {
			return sessionRepository.list();
		}

	}

	@GetMapping
	@RequestMapping("{id}")
	public Session get(@PathVariable Long id) {
		return sessionRepository.find(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Session create(@RequestBody final Session session) {
		return sessionRepository.create(session);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		sessionRepository.delete(id);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.PUT)
	public Session update(@PathVariable Long id, @RequestBody Session session) {
		return sessionRepository.update(id, session);
	}
}
