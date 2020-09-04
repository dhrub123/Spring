package com.dhruba.springboot.conference.scheduler.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "ticket_types")
public class TicketType {

	@Id
	@Column(name = "ticket_type_code")
	private String ticketTypeCode;

	@Column(name = "ticket_type_name")
	private String ticketTypeName;

	@Column(name = "description")
	private String description;

	@Column(name = "includes_workshop")
	private Boolean includesWorkshop;

	@OneToMany(mappedBy = "ticketType")
	@JsonIgnore
	private List<TicketPrice> ticketPrices;

	public TicketType() {
	}

	public String getTicketTypeCode() {
		return ticketTypeCode;
	}

	public void setTicketTypeCode(String ticketTypeCode) {
		this.ticketTypeCode = ticketTypeCode;
	}

	public String getTicketTypeName() {
		return ticketTypeName;
	}

	public void setTicketTypeName(String ticketTypeName) {
		this.ticketTypeName = ticketTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getIncludesWorkshop() {
		return includesWorkshop;
	}

	public void setIncludesWorkshop(Boolean includesWorkshop) {
		this.includesWorkshop = includesWorkshop;
	}

	public List<TicketPrice> getTicketPrices() {
		return ticketPrices;
	}

	public void setTicketPrices(List<TicketPrice> ticketPrices) {
		this.ticketPrices = ticketPrices;
	}

}
