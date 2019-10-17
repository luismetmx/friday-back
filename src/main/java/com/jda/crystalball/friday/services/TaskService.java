package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jda.crystalball.friday.entities.TaskEntity;
import com.jda.crystalball.friday.repositories.TaskRepository;

@Service
public class TaskService 
{
	@Autowired
	TaskRepository taskRepository;
	
	public List<TaskEntity> getAllTask()
	{
		return (List<TaskEntity>) taskRepository.findAll();
	}
	
	public TaskEntity createTask(TaskEntity task)
	{
		return taskRepository.save(task);
	}
	
	public TaskEntity updateTask(Long Id, TaskEntity task)
	{
		TaskEntity updatedTask;
		Optional<TaskEntity> searchEntity = taskRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			TaskEntity sample = searchEntity.get();
            sample.setName(task.getName());
			sample.setSolutionEntity(task.getSolutionEntity());
			sample.setPhase(task.getPhase());
			sample.setProjectType(task.getProjectType());
			sample.setTeamEntity(task.getTeamEntity());
			sample.setIsActive(task.getIsActive());
            updatedTask = taskRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedTask;
	}
	
	public ResponseEntity<Object> deleteTask(Long Id)
	{
        Optional<TaskEntity> sampleEntity = taskRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	TaskEntity sample = sampleEntity.get();
        	taskRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
