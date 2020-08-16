package com.example.SpringBoot.beans;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PRO_TEAM")
public class Team {
	@Id
	@SequenceGenerator(name="pro_team_seq_gen", sequenceName="PRO_TEAM_SEQ", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.AUTO, generator="pro_team_seq_gen")
	private int id;
	
	@Column
	private String name;
	
	@Column 
	private String teamimage;
	@Column
	private String teaminfo;

	public Team() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Team(int id, String name, String teamimage, String teaminfo) {
		super();
		this.id = id;
		this.name = name;
		this.teamimage = teamimage;
		this.teaminfo = teaminfo;
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

	public String getTeamimage() {
		return teamimage;
	}

	public void setTeamimage(String teamimage) {
		this.teamimage = teamimage;
	}

	public String getTeaminfo() {
		return teaminfo;
	}

	public void setTeaminfo(String teaminfo) {
		this.teaminfo = teaminfo;
	}

	@Override
	public String toString() {
		return "Team [id=" + id + ", name=" + name + ", teamimage=" + teamimage + ", teaminfo=" + teaminfo + "]";
	}

	
}

