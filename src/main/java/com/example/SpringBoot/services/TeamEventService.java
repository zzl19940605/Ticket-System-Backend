package com.example.SpringBoot.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringBoot.beans.TeamEvent;
import com.example.SpringBoot.daos.TeamEventDao;
import com.example.SpringBoot.http.Response;


@Service
public class TeamEventService {
	@Autowired
	TeamEventDao teamEventDao;
	
	public List<TeamEvent> getTeamEventByTeamId(int teamId ) {
		return teamEventDao.findByTeamId(teamId);
	}
	
	public List<TeamEvent> getAll(){
		return teamEventDao.findAll();
	}
	
	public Response updateTeamEvent(TeamEvent teamEvent) {
		try {
			teamEventDao.save(teamEvent);
			return new Response(true);
		}catch(Exception e) {
			return new Response(false, 400, e.getMessage());
		}
	}
	
	
	public Response updateupdateTeamEvent(TeamEvent teamEvent) {
        try {
        	TeamEvent p = teamEventDao.findById(teamEvent.getId()).get();
        	p.setId(teamEvent.getId());
            p.setCourtname(teamEvent.getCourtname());
            p.setCourtimage(teamEvent.getCourtimage());
            p.setGametime(teamEvent.getGametime());
            p.setEventdate(teamEvent.getEventdate());
            p.setEventinfo(teamEvent.getEventinfo());
            p.setEventprice(teamEvent.getEventprice());
            p.setTeam(teamEvent.getTeam());
            teamEventDao.save(p);
            return new Response(true);
        }catch(Exception e) {
            return new Response(false);
        }
    }
	
	public Response deleteTeamEvent(int id) {
		if(teamEventDao.findById(id).get()!=null) {
			teamEventDao.deleteById(id);
			return new Response(true);
		}else {
			return new Response(false, "teamEvent is not found");
		}
	}
	
	
	@Transactional
	public void deleteTeamEventByEventDate(int eventdate) {
		
		teamEventDao.deleteByEventdate(eventdate);
	}
}
