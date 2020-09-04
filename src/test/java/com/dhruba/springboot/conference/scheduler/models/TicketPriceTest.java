package com.dhruba.springboot.conference.scheduler.models;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.dhruba.springboot.conference.scheduler.repository.PricingCategoryRepository;
import com.dhruba.springboot.conference.scheduler.repository.TicketPriceRespository;
import com.dhruba.springboot.conference.scheduler.repository.TicketTypeRepository;

@SpringBootTest
class TicketPriceTest {

	@Autowired
	private TicketPriceRespository ticketPriceRespository;

	@Autowired
	private TicketTypeRepository ticketTypeRepository;

	@Autowired
	private PricingCategoryRepository pricingCategoryRepository;

	@Test
	public void find() {
		TicketPrice ticketPrice = ticketPriceRespository.getOne(1l);
		assertNotNull(ticketPrice);
	}
	
	@Test
	public void testSaveAndGetAndDelete() {
		TicketPrice ticketPrice = new TicketPrice();
		ticketPrice.setBasePrice(BigDecimal.valueOf(200,2));
		ticketPrice.setPricingCategory(pricingCategoryRepository.getOne("E"));
		ticketPrice.setTicketType(ticketTypeRepository.getOne("C"));
		ticketPrice = ticketPriceRespository.saveAndFlush(ticketPrice);
		
		TicketPrice toBeDeletedTicketPrice = ticketPriceRespository.getOne(ticketPrice.getTicketPriceId());
		ticketPriceRespository.deleteById(toBeDeletedTicketPrice.getTicketPriceId());
		
	}

}
