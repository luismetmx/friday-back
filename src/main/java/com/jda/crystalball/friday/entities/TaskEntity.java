package com.jda.crystalball.friday.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Task")
public class TaskEntity 
{
	@Id
    @Column(name = "id")
    int Id;
 
    @Column(name = "description")
    String description;
    
    @ManyToOne
    @JoinColumn(name ="solution_id")
    private SolutionEntity solutionEntity;

	public TaskEntity() 
	{
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SolutionEntity getSolutionEntity() {
		return solutionEntity;
	}

	public void setSolutionEntity(SolutionEntity solutionEntity) {
		this.solutionEntity = solutionEntity;
	}

}
