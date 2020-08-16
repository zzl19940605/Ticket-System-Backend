package com.example.SpringBoot.beans;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "PRO_TEAM_EVENT")
public class TeamEvent {
	
	@Id
	@SequenceGenerator(name="pro_team_event_seq_gen", sequenceName="PRO_TEAM_EVENT_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="pro_team_event_seq_gen")
	private int id;
	
	@Column 
	private String courtname;
	@Column 
	private String courtimage;
	
	@Column
	private String gametime;
	
	@Column
	private int eventdate;
	
	@Column 
	private String eventinfo;
	
	@Column
	private String eventprice;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "TEAM_ID")		
	private Team team;

	public TeamEvent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeamEvent(int id, String courtname, String courtimage, String gametime, int eventdate, String eventinfo,
			String eventprice, Team team) {
		super();
		this.id = id;
		this.courtname = courtname;
		this.courtimage = courtimage;
		this.gametime = gametime;
		this.eventdate = eventdate;
		this.eventinfo = eventinfo;
		this.eventprice = eventprice;
		this.team = team;
	}

	@Override
	public String toString() {
		return "TeamEvent [id=" + id + ", courtname=" + courtname + ", courtimage=" + courtimage + ", gametime="
				+ gametime + ", eventdate=" + eventdate + ", eventinfo=" + eventinfo + ", eventprice=" + eventprice
				+ ", team=" + team + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCourtname() {
		return courtname;
	}

	public void setCourtname(String courtname) {
		this.courtname = courtname;
	}

	public String getCourtimage() {
		return courtimage;
	}

	public void setCourtimage(String courtimage) {
		this.courtimage = courtimage;
	}

	public String getGametime() {
		return gametime;
	}

	public void setGametime(String gametime) {
		this.gametime = gametime;
	}

	public int getEventdate() {
		return eventdate;
	}

	public void setEventdate(int eventdate) {
		this.eventdate = eventdate;
	}

	public String getEventinfo() {
		return eventinfo;
	}

	public void setEventinfo(String eventinfo) {
		this.eventinfo = eventinfo;
	}

	public String getEventprice() {
		return eventprice;
	}

	public void setEventprice(String eventprice) {
		this.eventprice = eventprice;
	}

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}

	
}
