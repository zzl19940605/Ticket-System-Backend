package com.example.SpringBoot.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.SpringBoot.beans.TeamEvent;


public interface TeamEventDao extends JpaRepository<TeamEvent,Integer>{
	List<TeamEvent> findByTeamId(int teamId);
//	@Query("delete from TeamEvent where eventdate=:eventdate")
	void deleteByEventdate(int eventdate);
}
