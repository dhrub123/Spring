package com.dhruba.springboot.conference.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dhruba.springboot.conference.scheduler.models.TicketPrice;

public interface TicketPriceRespository extends JpaRepository<TicketPrice, Long> {

}
