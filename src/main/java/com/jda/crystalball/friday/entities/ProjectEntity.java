package com.jda.crystalball.friday.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Project")
public class ProjectEntity {
    @Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "project_type")
    String projectType;

    @Column(name = "start_date")
    LocalDateTime startDatetime;

    @Column(name = "comp_date")
    LocalDateTime compDatetime;

    @ManyToOne()
	@JoinColumn(name = "sol_id", referencedColumnName = "id", insertable = false, updatable = false)
    SolutionEntity solution;
    
    public ProjectEntity() {}

    public SolutionEntity getSolution() {
        return this.solution;
    }

    public void setSolution(SolutionEntity solution) {
        this.solution = solution;
    }

    public String getProjectType() {
        return this.projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public LocalDateTime getStartDatetime() {
        return this.startDatetime;
    }

    public void setStartDatetime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }

    public LocalDateTime getCompDatetime() {
        return this.compDatetime;
    }

    public void setCompDatetime(LocalDateTime compDatetime) {
        this.compDatetime = compDatetime;
    }

    
}
