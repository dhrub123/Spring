package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhruba.springboot.conference.scheduler.models.Session;

/**
 * @author dhruba
 * We have to create an interface and extend JpaRepository
 * The 1stArgument is the entity for which the respository is being created - in this case session
 * The 2ndArgument is the data type of the primary key - in this case private Long session_id 
 */
public interface SessionJpaRepository extends JpaRepository<Session, Long>,SessionCustomJpaRepository {
	
	//the name is findBy + Variable name from Entity + Contains
	public List<Session> findBySessionNameContains(String name);
	
	//Starting with - Ending With - Containing
	public List<Session> findBySessionNameStartingWith(String name);
	public List<Session> findBySessionNameEndingWith(String name);
	public List<Session> findBySessionNameContaining(String name);
		
	//EqualTo and NotEqualTo
	public List<Session> findBySessionLength(Integer length);
	public List<Session> findBySessionLengthNot(Integer length);
	public List<Session> findBySessionLengthIs(Integer length);
	public List<Session> findBySessionLengthEquals(Integer length);
	
	//Like - Not Like
	public List<Session> findBySessionNameLike(String name);
	public List<Session> findBySessionNameNotLike(String name);
	
	//Greater Than - Less Than
	public List<Session> findBySessionLengthLessThan(Integer length);
	public List<Session> findBySessionLengthLessThanEqual(Integer length);
	public List<Session> findBySessionLengthGreaterThan(Integer length);
	public List<Session> findBySessionLengthGreaterThanEqual(Integer length);
	
	/* Sorting 
	The return type is a Page<Session> 
	A pageable argument is passed as well
	*/
	@Query("select s from Session s where s.sessionName like %:name") 
	Page<Session> getSessionsWithName(@Param("name") String name, Pageable pageable);
	
	

}
