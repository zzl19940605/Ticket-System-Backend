package com.example.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SpringBoot.beans.Team;
import com.example.SpringBoot.beans.TeamEvent;
import com.example.SpringBoot.daos.TeamDao;
import com.example.SpringBoot.daos.TeamEventDao;
import com.example.SpringBoot.http.Response;

@Service
public class TeamService {
	
	@Autowired
	TeamEventDao teamEventDao;
	@Autowired
	TeamDao teamDao;
	
	public List<Team> getAll(){
		return teamDao.findAll();
	}
	
	public Response updateTeam(Team team) {
		try {
//			team.setTeamEvent(team.getTeamEvent());
//			List<TeamEvent> teamEvent =team.getTeamEvent();
//			teamEvent.forEach(teamevent=>{
//			});
			teamDao.save(team);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false, 400, e.getMessage());
		}
	}
	
	public Response deleteTeam(int id) {
		if(teamDao.findById(id).get()!=null) {
			teamDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "team is not found");
		}
	}
	
}
