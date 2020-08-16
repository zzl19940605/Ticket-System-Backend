package com.example.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.beans.TeamEvent;
import com.example.SpringBoot.beans.TeamEventTicket;
import com.example.SpringBoot.daos.TeamEventTicketDao;
import com.example.SpringBoot.http.Response;

@Service
public class TeamEventTicketService {
	@Autowired
	TeamEventTicketDao teamEventTicketDao;
	
	public List<TeamEventTicket> getTeamEventTicketByTeamEventId(int teameventId ) {
		return teamEventTicketDao.findByTeameventId(teameventId);
	}
	
	public List<TeamEventTicket> getAll(){
		return teamEventTicketDao.findAll();
	}
	
	public Response updateTeamEventTicket(TeamEventTicket teamEventTicket) {
		try {
			teamEventTicketDao.save(teamEventTicket);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false, 400, e.getMessage());
		}
	}
	
	public Response deleteTeamEventTicket(int id) {
		
		if(teamEventTicketDao.findById(id).get()!=null) {
			teamEventTicketDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "teamEvent is not found");
		}
	}
}