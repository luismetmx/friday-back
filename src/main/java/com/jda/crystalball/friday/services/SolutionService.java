package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jda.crystalball.friday.entities.SolutionEntity;
import com.jda.crystalball.friday.repositories.SolutionRepository;

@Service
public class SolutionService 
{
	@Autowired
	SolutionRepository solutionRepository;
	
	public List<SolutionEntity> getAllSolutions()
	{
		return (List<SolutionEntity>) solutionRepository.findAll();
	}
	
	public SolutionEntity createSolution(SolutionEntity solution)
	{
		return solutionRepository.save(solution);
	}
	
	public SolutionEntity updateSolution(Long Id, SolutionEntity solution)
	{
		SolutionEntity updatedSolution;
		Optional<SolutionEntity> searchEntity = solutionRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			SolutionEntity sample = searchEntity.get();
            sample.setName(solution.getName());
            //sample.setResources(solution.getResources());
            sample.setTeam(solution.getTeam());
            updatedSolution = solutionRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedSolution;
	}
	
	public ResponseEntity<Object> deleteSolution(Long Id)
	{
        Optional<SolutionEntity> sampleEntity = solutionRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	SolutionEntity sample = sampleEntity.get();
        	solutionRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
