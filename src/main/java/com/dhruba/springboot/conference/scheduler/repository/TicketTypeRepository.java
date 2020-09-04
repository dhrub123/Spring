package com.dhruba.springboot.conference.scheduler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {
	
	public List<TicketType> findByIncludesWorkshopTrue();
	public List<TicketType> findByIncludesWorkshopFalse();
}
