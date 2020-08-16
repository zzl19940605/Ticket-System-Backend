package com.example.SpringBoot.controllers;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.SpringBoot.beans.TeamEvent;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.TeamEventService;


@RestController
@RequestMapping("/teamEvents")
public class TeamEventController {
	
	@Autowired
	private TeamEventService teamEventService;
	
	@GetMapping
	public List<TeamEvent> findAll() {
		
		List<TeamEvent> ls = teamEventService.getAll();
		if (ls.size() != 0) Collections.sort(ls, (t1, t2) -> Integer.compare(t1.getId(), t2.getId()));
		return ls;
		
	}
	
	@GetMapping("/teamId/{teamId}")
	// i can add a sort to make the data from the oracle display in some specific sort method
	public List<TeamEvent> getTeamEventByTeamId(@PathVariable int teamId) {
		
//		return teamEventService.getTeamEventByTeamId(teamId);
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
		List<TeamEvent> ls = teamEventService.getTeamEventByTeamId(teamId);
		if (ls.size() != 0) Collections.sort(ls, (t1, t2) -> Integer.compare(t1.getId(), t2.getId()));
		return ls;
	}

	@PostMapping
	public Response save(@RequestBody TeamEvent teamEvent) {
		return teamEventService.updateTeamEvent(teamEvent);
	}
	
	@PutMapping
	public Response update(@RequestBody TeamEvent teamEvent) {
		return teamEventService.updateupdateTeamEvent(teamEvent);
	}
	
	@DeleteMapping("/{eventdate}")
	public void deleteTeamEventByEventDate(@PathVariable("eventdate") int eventdate) {
		teamEventService.deleteTeamEventByEventDate(eventdate) ;
	}
}
