package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.Speaker;

/**
 * @author dhruba
 * We have to create an interface and extend JpaRepository
 * The 1stArgument is the entity for which the respository is being created - in this case speaker
 * The 2ndArgument is the data type of the primary key - in this case private Long speaker_id
 */
public interface SpeakerRepository extends JpaRepository<Speaker, Long> {
	
	//And Or
	public List<Speaker> findByFirstNameAndLastName(String firstName, String lastName);
	public List<Speaker> findByFirstNameOrLastName(String firstName, String lastName);
	
	//NULL - NON NULL
	public List<Speaker> findBySpeakerPhotoNull();
	
	//IN - NOT IN - IGNORE CASE
	public List<Speaker> findByCompanyIn(List<String> companies);
	public List<Speaker> findByCompanyNotIn(List<String> companies);
	public List<Speaker> findByCompanyIgnoreCase(String companies);
	
	//ORDER BY
	public List<Speaker> findByFirstNameOrderByLastNameAsc(String name);
	public List<Speaker> findByFirstNameOrderByLastNameDesc(String name);
	
	//FIRST - TOP - DISTINCT
	public Speaker findFirstByFirstName(String name);
	public List<Speaker> findTop5ByFirstName(String name);
	public List<Speaker> findDistinctByFirstName(String name);
}
