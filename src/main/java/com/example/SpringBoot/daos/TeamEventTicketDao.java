package com.example.SpringBoot.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.beans.TeamEventTicket;

public interface TeamEventTicketDao extends JpaRepository<TeamEventTicket, Integer>{
	List<TeamEventTicket> findByTeameventId(int teameventId);
}
