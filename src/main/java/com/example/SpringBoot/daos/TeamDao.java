package com.example.SpringBoot.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringBoot.beans.Team;

public interface TeamDao extends JpaRepository<Team, Integer>{

}
