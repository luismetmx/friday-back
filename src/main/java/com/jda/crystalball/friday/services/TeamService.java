package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jda.crystalball.friday.entities.TeamEntity;
import com.jda.crystalball.friday.repositories.TeamRepository;

@Service
public class TeamService 
{
	@Autowired
	TeamRepository teamRepository;
	
	public List<TeamEntity> getAllTeams()
	{
		return (List<TeamEntity>) teamRepository.findAll();
	}
	
	public TeamEntity createTeam(TeamEntity team)
	{
		return teamRepository.save(team);
	}
	
	public TeamEntity updateTeam(Long Id, TeamEntity team)
	{
		TeamEntity updatedTeam;
		Optional<TeamEntity> searchEntity = teamRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			TeamEntity sample = team;
            sample.setName(team.getName());
            updatedTeam = teamRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedTeam;
	}
	
	public ResponseEntity<Object> deleteTask(Long Id)
	{
        Optional<TeamEntity> sampleEntity = teamRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	TeamEntity sample = sampleEntity.get();
        	teamRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
