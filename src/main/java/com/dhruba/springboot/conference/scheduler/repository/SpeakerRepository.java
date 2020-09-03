package com.dhruba.springboot.conference.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.Speaker;

/**
 * @author dhruba
 * We have to create an interface and extend JpaRepository
 * The 1stArgument is the entity for which the respository is being created - in this case speaker
 * The 2ndArgument is the data type of the primary key - in this case private Long speaker_id
 */
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
}
