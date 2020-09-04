package com.dhruba.springboot.conference.scheduler.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "ticket_prices")
public class TicketPrice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ticket_price_id")
	private Long ticketPriceId;

	@Column(name = "base_price")
	private BigDecimal basePrice;

	@ManyToOne
	@JoinColumn(name = "ticket_type_code", nullable = false, updatable = false)
	private TicketType ticketType;

	@ManyToOne
	@JoinColumn(name = "pricing_category_code", nullable = false, updatable = false)
	private PricingCategory pricingCategory;
	
	public TicketPrice() {
	}

	public Long getTicketPriceId() {
		return ticketPriceId;
	}

	public void setTicketPriceId(Long ticketPriceId) {
		this.ticketPriceId = ticketPriceId;
	}

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public TicketType getTicketType() {
		return ticketType;
	}

	public void setTicketType(TicketType ticketType) {
		this.ticketType = ticketType;
	}

	public PricingCategory getPricingCategory() {
		return pricingCategory;
	}

	public void setPricingCategory(PricingCategory pricingCategory) {
		this.pricingCategory = pricingCategory;
	}
	
}
