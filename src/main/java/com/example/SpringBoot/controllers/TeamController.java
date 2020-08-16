package com.example.SpringBoot.controllers;

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

import com.example.SpringBoot.beans.Team;
import com.example.SpringBoot.http.Response;
import com.example.SpringBoot.services.TeamService;


@RestController
@RequestMapping("/teams")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@GetMapping
	public List<Team> findAll() {
		return teamService.getAll();
	}

	@PostMapping
	public Response save(@RequestBody Team team) {
		return teamService.updateTeam(team);
	}
	
	
	@DeleteMapping("/{id}")
	public Response deleteSampleById(@PathVariable("id") int id) {
		return teamService.deleteTeam(id);
	}
	
	
	
}
