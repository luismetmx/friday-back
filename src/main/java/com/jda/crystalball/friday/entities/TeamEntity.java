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
@Table(name="Team")
public class TeamEntity 
{
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
 
    @Column(name = "name")
	String name;
	
	@ManyToOne()
	@JoinColumn(name = "sol_id", referencedColumnName = "id", insertable = false, updatable = false)
	SolutionEntity solution;

	public TeamEntity() 
	{
	}

	public int getId() 
	{
		return Id;
	}

	public void setId(int id) 
	{
		Id = id;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public SolutionEntity getSolution() {
		return this.solution;
	}

	public void setSolution(SolutionEntity solution) {
		this.solution = solution;
	}
    
}
