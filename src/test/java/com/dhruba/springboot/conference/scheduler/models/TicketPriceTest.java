package com.dhruba.springboot.conference.scheduler.models;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import java.util.List;

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
	
	@Test
	public void testBoolean() {
		List<TicketType> ticketTypes = ticketTypeRepository.findByIncludesWorkshopTrue();
		assertTrue(ticketTypes.size() > 0);
		
		ticketTypes = ticketTypeRepository.findByIncludesWorkshopFalse();
		assertTrue(ticketTypes.size() > 0);
	}
	
	@Test
	public void testQueryAnnotation() {
		List<TicketPrice> tickets = ticketPriceRespository.getTicketsUnderPriceWithWorkshops(BigDecimal.valueOf(1000));
		assertTrue(tickets.size() > 0);
	}
	
	@Test
	public void testNamedQuery() {
		List<TicketPrice> tickets = ticketPriceRespository.namedFindTicketsByPricingCategoryName("Regular");
		assertTrue(tickets.size() > 0);
	}
	
	@Test
	public void testNativeNamedQuery() {
		List<TicketPrice> tickets = ticketPriceRespository.nativeFindTicketsByCategoryWithWorkshop("Regular");
		assertTrue(tickets.size() > 0);
	}

}
