package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import com.dhruba.springboot.conference.scheduler.models.Session;

public interface SessionCustomJpaRepository {
	List<Session> customGetSessions();
}
