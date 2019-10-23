package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.jda.crystalball.friday.entities.ProjectEntity;
import com.jda.crystalball.friday.repositories.ProjectRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProjectService 
{
	@Autowired
	ProjectRepository projectRepository;
	
	public List<ProjectEntity> getAllProjects()
	{
		return (List<ProjectEntity>) projectRepository.findAll();
	}

	public ProjectEntity getProjectById(int id) {
		ProjectEntity project;
		Optional<ProjectEntity> searchEntity = projectRepository.findById(id);

		if (searchEntity.isPresent())
		{
			project = searchEntity.get();
		} else {
			throw new EntityNotFoundException();
		}

		return project;
	}
	
	public ProjectEntity createProject(ProjectEntity project)
	{
		return projectRepository.save(project);
	}
	
	public ProjectEntity updateProject(int Id, ProjectEntity project)
	{
		ProjectEntity updatedTask;
		Optional<ProjectEntity> searchEntity = projectRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			ProjectEntity sample = searchEntity.get();
            sample.setProjectType(project.getProjectType());
            sample.setSolution(project.getSolution());
            sample.setStartDatetime(project.getStartDatetime());
			sample.setCompDatetime(project.getCompDatetime());
			sample.setName(project.getName());
            updatedTask = projectRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedTask;
	}
	
	public ResponseEntity<Object> deleteProject(int Id)
	{
        Optional<ProjectEntity> sampleEntity = projectRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	ProjectEntity sample = sampleEntity.get();
        	projectRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
