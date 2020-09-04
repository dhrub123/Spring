package com.dhruba.springboot.conference.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.TicketType;

public interface TicketTypeRepository extends JpaRepository<TicketType, String> {

}
