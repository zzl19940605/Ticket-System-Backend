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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="PRO_ORDER")
public class Order {
	@Id
	@SequenceGenerator(name="pro_order_seq_gen", sequenceName="PRO_ORDER_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="pro_order_seq_gen")
	private int id;
	
	@Column
	private String name;
	
	@Column 
	private String address;
	@Column
	private int zip;
	
	@OneToOne
	@JoinColumn(name = "TICKET_ID")
//	@JsonIgnore
	TeamEventTicket teamEventTicket;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "USER_ID")
//	@JsonIgnore
	User user;

	public Order(int id, String name, String address, int zip, TeamEventTicket teamEventTicket, User user) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.zip = zip;
		this.teamEventTicket = teamEventTicket;
		this.user = user;
	}

	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public TeamEventTicket getTeamEventTicket() {
		return teamEventTicket;
	}

	public void setTeamEventTicket(TeamEventTicket teamEventTicket) {
		this.teamEventTicket = teamEventTicket;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", name=" + name + ", address=" + address + ", zip=" + zip + ", teamEventTicket="
				+ teamEventTicket + ", user=" + user + "]";
	}
	
	
	
}
