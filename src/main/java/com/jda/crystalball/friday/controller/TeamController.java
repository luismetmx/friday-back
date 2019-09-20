package com.jda.crystalball.friday.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jda.crystalball.friday.entities.TeamEntity;
import com.jda.crystalball.friday.services.TeamService;

@RestController
public class TeamController 
{
	@Autowired
	TeamService teamService;
	
	@RequestMapping(value = "/teams")
	public List<TeamEntity> getTasks()
	{
		return teamService.getAllTeams();
	}
	
	@RequestMapping(value = "/createteam", method = RequestMethod.POST)
    public TeamEntity createTeam(@Valid @RequestBody TeamEntity teamEntity) 
	{
        return teamService.createTeam(teamEntity);
    }
 
    @RequestMapping(value = "/deleteteam/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id) 
    {
        return teamService.deleteTask(id);
    }
 
    @RequestMapping(value = "/updateteam/{id}", method = RequestMethod.PUT)
    public TeamEntity updateTask(@PathVariable(value = "id") Long id,
            @Valid @RequestBody TeamEntity teamEntity) 
    {
        return teamService.updateTeam(id, teamEntity);
    }
}
