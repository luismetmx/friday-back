package com.jda.crystalball.friday.controller;

import java.util.List;

import javax.validation.Valid;

import com.jda.crystalball.friday.entities.ProjectEntity;
import com.jda.crystalball.friday.services.ProjectService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProjectController 
{
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/projects")
	public List<ProjectEntity> getProjects()
	{
		return projectService.getAllProjects();
    }
    
    @RequestMapping(value = "/project/{id}")
	public ProjectEntity getProjectById(@PathVariable(value = "id") int id)
	{
		return projectService.getProjectById(id);
	}
	
	@RequestMapping(value = "/createproject", method = RequestMethod.POST)
    public ProjectEntity createProject(@Valid @RequestBody ProjectEntity projectEntity) 
	{
        return projectService.createProject(projectEntity);
    }
 
    @RequestMapping(value = "/deleteproject/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteProject(@PathVariable(value = "id") int id) 
    {
        return projectService.deleteProject(id);
    }
 
    @RequestMapping(value = "/updateproject/{id}", method = RequestMethod.PUT)
    public ProjectEntity updateProject(@PathVariable(value = "id") int id,
            @Valid @RequestBody ProjectEntity projectEntity) 
    {
        return projectService.updateProject(id, projectEntity);
    }
}
