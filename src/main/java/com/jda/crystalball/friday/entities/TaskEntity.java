package com.jda.crystalball.friday.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class TaskEntity 
{
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
 
    @Column(name = "name")
	String name;

	@Column(name = "phase")
	String phase;

	@Column(name = "project_type")
	String projectType;

	@Column(name = "active")
	boolean isActive;
 
    @ManyToOne
    @JoinColumn(name ="solution_id")
	private SolutionEntity solutionEntity;
	
	@ManyToOne
	@JoinColumn(name = "owner_team_id")
	private TeamEntity teamEntity;

	public TaskEntity() 
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

	public SolutionEntity getSolutionEntity() {
		return solutionEntity;
	}

	public void setSolutionEntity(SolutionEntity solutionEntity) {
		this.solutionEntity = solutionEntity;
	}

	public String getPhase() {
		return this.phase;
	}

	public void setPhase(String phase) {
		this.phase = phase;
	}

	public String getProjectType() {
		return this.projectType;
	}

	public void setProjectType(String projectType) {
		this.projectType = projectType;
	}

	public TeamEntity getTeamEntity() {
		return this.teamEntity;
	}

	public void setTeamEntity(TeamEntity teamEntity) {
		this.teamEntity = teamEntity;
	}
	
	public boolean getIsActive() {
		return this.isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
