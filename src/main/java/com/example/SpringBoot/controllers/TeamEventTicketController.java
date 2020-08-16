package com.example.SpringBoot.controllers;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBoot.beans.TeamEvent;
import com.example.SpringBoot.beans.TeamEventTicket;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.TeamEventTicketService;

@RestController
@RequestMapping("/teamEventTicket")
public class TeamEventTicketController {
	
	@Autowired
	private TeamEventTicketService teamEventTicketService;
	
	@GetMapping
	public List<TeamEventTicket> findAll() {
		return teamEventTicketService.getAll();
	}
	
	@GetMapping("/teameventId/{teameventId}")
	// i can add a sort to make the data from the oracle display in some specific sort method
	public List<TeamEventTicket> getTeamEventTicketByTeamEventId(@PathVariable int teameventId) {
		
		return teamEventTicketService.getTeamEventTicketByTeamEventId(teameventId);
//		for (TeamEvent te : teamEventService.getTeamEventByTeamId(teamId)) {
//			System.out.println(te.getId());
//		}
		
//		Comparator<TeamEvent> t=new Comparator<TeamEvent>(){
//			@Override
//			public int compare(TeamEvent t1, TeamEvent t2) {
//				//if positive o1>o2
//				//if.....
//				return Integer.compare(t1.getId(),t2.getId());
//			}	
//		};
//		List<TeamEventTicket> ls = teamEventTicketService.getTeamEventTicketByTeamEventId(teameventId);
//		if (ls.size() != 0) Collections.sort(ls, (t1, t2) -> Integer.compare(t1.getId(), t2.getId()));
//		return ls;
	}

	@PostMapping
	public Response save(@RequestBody TeamEventTicket teamEventTicket) {
		return teamEventTicketService.updateTeamEventTicket(teamEventTicket);
	}
	
	
	@DeleteMapping("/{id}")
	public Response deleteSampleById(@PathVariable("id") int id) {
		return teamEventTicketService.deleteTeamEventTicket(id);
	}
}


