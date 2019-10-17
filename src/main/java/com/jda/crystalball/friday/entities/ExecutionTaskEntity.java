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
@Table(name = "ExecutionTask")
public class ExecutionTaskEntity {
    @Id
	@Column(name = "id", updatable = false, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    @Column(name = "status")
    String status;

    @Column(name = "comments")
    String comments;

    @ManyToOne()
    @JoinColumn(name = "task_id", referencedColumnName = "id", insertable = false, updatable = false)
    TaskEntity task;

    @ManyToOne()
    @JoinColumn(name = "project_id", referencedColumnName = "id", insertable = false, updatable = false)
    ProjectEntity project;
    
    @ManyToOne()
    @JoinColumn(name = "resource_id", referencedColumnName = "id", insertable = false, updatable = false)
    ResourcesEntity resource;

    @Column(name = "target_date")
    LocalDateTime targetDate;

    @Column(name = "compl_date")
    LocalDateTime complDate;

    public LocalDateTime getComplDate() {
        return this.complDate;
    }

    public void setComplDate(LocalDateTime complDate) {
        this.complDate = complDate;
    }

    public LocalDateTime getTargetDate() {
        return this.targetDate;
    }

    public void setTargetDate(LocalDateTime targetDate) {
        this.targetDate = targetDate;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return this.comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public TaskEntity getTask() {
        return this.task;
    }

    public void setTask(TaskEntity task) {
        this.task = task;
    }

    public ProjectEntity getProject() {
        return this.project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public ResourcesEntity getResource() {
        return this.resource;
    }

    public void setResource(ResourcesEntity resource) {
        this.resource = resource;
    }

}