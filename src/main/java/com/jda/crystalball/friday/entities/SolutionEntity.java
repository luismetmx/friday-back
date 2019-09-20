package com.jda.crystalball.friday.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Solution")
public class SolutionEntity 
{

	@Id
    @Column(name = "id")
    int Id;
 
    @Column(name = "name")
    String name;
    
//    @OneToMany(cascade = CascadeType.ALL)
//    private Set<ResourcesEntity> resources;
    
    @ManyToOne
    @JoinColumn(name="team_id")
    private TeamEntity team;
    
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

//	public Set<ResourcesEntity> getResources() {
//		return resources;
//	}
//
//	public void setResources(Set<ResourcesEntity> resources) {
//		this.resources = resources;
//	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}
    
}
