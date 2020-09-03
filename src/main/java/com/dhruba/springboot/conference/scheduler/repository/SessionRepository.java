package com.dhruba.springboot.conference.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.Session;

/**
 * @author dhruba
 * We have to create an interface and extend JpaRepository
 * The 1stArgument is the entity for which the respository is being created - in this case session
 * The 2ndArgument is the data type of the primary key - in this case private Long session_id 
 */
public interface SessionRepository extends JpaRepository<Session, Long> {
}
