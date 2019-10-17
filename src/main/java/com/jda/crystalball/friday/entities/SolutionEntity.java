package com.jda.crystalball.friday.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="Solution")
public class SolutionEntity 
{

	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
 
    @Column(name = "name")
	String name;
	
	@OneToMany(targetEntity = TeamEntity.class, mappedBy = "solution", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<TeamEntity> teams = new ArrayList<>();

	@OneToMany(targetEntity = TaskEntity.class, mappedBy = "solutionEntity", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	List<TeamEntity> tasks = new ArrayList<>();
 
    public SolutionEntity()
    {
    	
    }

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<TeamEntity> getTeams() {
		return this.teams;
	}

	public void setTeams(List<TeamEntity> teams) {
		this.teams = teams;
	}

	public List<TeamEntity> getTasks() {
		return this.tasks;
	}

	public void setTasks(List<TeamEntity> tasks) {
		this.tasks = tasks;
	}
    
}
