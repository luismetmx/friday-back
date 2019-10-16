package com.jda.crystalball.friday.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="Resources")
public class ResourcesEntity 
{
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;
 
    @Column(name = "name")
    String name;
 
    @Column(name = "mail")
    String mail;
    
    @ManyToOne
    @JoinColumn(name ="solution_id")
    private SolutionEntity solutionEntity;
    
    public ResourcesEntity()
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

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public SolutionEntity getSolutionEntity() {
		return solutionEntity;
	}

	public void setSolutionEntity(SolutionEntity solutionEntity) {
		this.solutionEntity = solutionEntity;
	}
    
    
    
}
