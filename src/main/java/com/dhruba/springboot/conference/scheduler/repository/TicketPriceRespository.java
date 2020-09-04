package com.dhruba.springboot.conference.scheduler.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dhruba.springboot.conference.scheduler.models.TicketPrice;

public interface TicketPriceRespository extends JpaRepository<TicketPrice, Long> {
	
	@Query("select tp from TicketPrice tp "
			+ "where tp.basePrice < ?1 "
			+ "and tp.ticketType.includesWorkshop = true" 
	)
	List<TicketPrice> getTicketsUnderPriceWithWorkshops(BigDecimal maxPrice);
	
	List<TicketPrice> namedFindTicketsByPricingCategoryName(@Param("name") String name);
	
	List<TicketPrice> nativeFindTicketsByCategoryWithWorkshop(@Param("name") String name);
}
