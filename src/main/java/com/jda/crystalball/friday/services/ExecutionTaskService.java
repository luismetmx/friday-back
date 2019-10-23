package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jda.crystalball.friday.entities.ExecutionTaskEntity;
import com.jda.crystalball.friday.repositories.ExecutionTaskRepository;

@Service
public class ExecutionTaskService 
{
	@Autowired
	ExecutionTaskRepository executionTaskRepository;
	
	public List<ExecutionTaskEntity> getAllExecutionTasks()
	{
		return (List<ExecutionTaskEntity>) executionTaskRepository.findAll();
    }
    public List<ExecutionTaskEntity> getExecutionTasksByStatus(String status)
	{
		return (List<ExecutionTaskEntity>) executionTaskRepository.findByStatus(status);
	}
	
	public ExecutionTaskEntity createExecutionTask(ExecutionTaskEntity executionTask)
	{
		return executionTaskRepository.save(executionTask);
	}
	
    public ExecutionTaskEntity updateExecutionTask(Long Id, ExecutionTaskEntity executionTask)
	{
		ExecutionTaskEntity updatedTask;
		Optional<ExecutionTaskEntity> searchEntity = executionTaskRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			ExecutionTaskEntity sample = searchEntity.get();
            sample.setComments(executionTask.getComments());
            sample.setComplDate(executionTask.getComplDate());
            sample.setProject(executionTask.getProject());
            sample.setResource(executionTask.getResource());
            sample.setStatus(executionTask.getStatus());
            sample.setTargetDate(executionTask.getTargetDate());
            sample.setTask(executionTask.getTask());
            updatedTask = executionTaskRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedTask;
	}
	
	public ResponseEntity<Object> deleteexecutionTask(Long Id)
	{
        Optional<ExecutionTaskEntity> sampleEntity = executionTaskRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	ExecutionTaskEntity sample = sampleEntity.get();
        	executionTaskRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
