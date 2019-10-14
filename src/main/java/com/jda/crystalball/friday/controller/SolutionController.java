package com.jda.crystalball.friday.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jda.crystalball.friday.entities.SolutionEntity;
import com.jda.crystalball.friday.services.SolutionService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SolutionController 
{
	@Autowired
	SolutionService solutionService;
	
	@RequestMapping(value = "/solutions")
	public List<SolutionEntity> getSolutions()
	{
		return solutionService.getAllSolutions();
	}
	
	@RequestMapping(value = "/createsolution", method = RequestMethod.POST)
    public SolutionEntity createSolution(@Valid @RequestBody SolutionEntity solutionEntity) 
	{
        return solutionService.createSolution(solutionEntity);
    }
 
    @RequestMapping(value = "/deletesolution/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSolution(@PathVariable(value = "id") Long id) 
    {
        return solutionService.deleteSolution(id);
    }
 
    @RequestMapping(value = "/updatesolution/{id}", method = RequestMethod.PUT)
    public SolutionEntity updateSolution(@PathVariable(value = "id") Long id,
            @Valid @RequestBody SolutionEntity solutionEntity) 
    {
        return solutionService.updateSolution(id, solutionEntity);
    }
}
