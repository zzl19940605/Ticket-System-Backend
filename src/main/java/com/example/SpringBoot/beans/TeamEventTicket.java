package com.example.SpringBoot.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PRO_TEAM_EVENT_TICKET")
public class TeamEventTicket {
	@Id
	@SequenceGenerator(name="pro_team_event_ticket_seq_gen", sequenceName="PRO_TEAM_EVENT_TICKET_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="pro_team_event_ticket_seq_gen")
	private int id;
	@Column
	private String ticketsession;
	@Column
	private int ticketrow;
	@Column 
	private int ticketprice;
	@Column 
	private int numberofticket;
	@Column
	private String seatimage;
	@Column
	private String eventdetail;
	@Column 
	private String seats;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "TEAMEVENT_ID")		
	private TeamEvent teamevent;

	public TeamEventTicket() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamEventTicket(int id, String ticketsession, int ticketrow, int ticketprice, int numberofticket,
			String seatimage, String eventdetail, String seats, TeamEvent teamevent) {
		super();
		this.id = id;
		this.ticketsession = ticketsession;
		this.ticketrow = ticketrow;
		this.ticketprice = ticketprice;
		this.numberofticket = numberofticket;
		this.seatimage = seatimage;
		this.eventdetail = eventdetail;
		this.seats = seats;
		this.teamevent = teamevent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTicketsession() {
		return ticketsession;
	}

	public void setTicketsession(String ticketsession) {
		this.ticketsession = ticketsession;
	}

	public int getTicketrow() {
		return ticketrow;
	}

	public void setTicketrow(int ticketrow) {
		this.ticketrow = ticketrow;
	}

	public int getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}

	public int getNumberofticket() {
		return numberofticket;
	}

	public void setNumberofticket(int numberofticket) {
		this.numberofticket = numberofticket;
	}

	public String getSeatimage() {
		return seatimage;
	}

	public void setSeatimage(String seatimage) {
		this.seatimage = seatimage;
	}

	public String getEventdetail() {
		return eventdetail;
	}

	public void setEventdetail(String eventdetail) {
		this.eventdetail = eventdetail;
	}

	public String getSeats() {
		return seats;
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public TeamEvent getTeamevent() {
		return teamevent;
	}

	public void setTeamevent(TeamEvent teamevent) {
		this.teamevent = teamevent;
	}

	@Override
	public String toString() {
		return "TeamEventTicket [id=" + id + ", ticketsession=" + ticketsession + ", ticketrow=" + ticketrow
				+ ", ticketprice=" + ticketprice + ", numberofticket=" + numberofticket + ", seatimage=" + seatimage
				+ ", eventdetail=" + eventdetail + ", seats=" + seats + ", teamevent=" + teamevent + "]";
	}

	
}
