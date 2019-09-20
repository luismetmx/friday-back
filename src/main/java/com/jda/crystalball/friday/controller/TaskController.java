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

import com.jda.crystalball.friday.entities.TaskEntity;
import com.jda.crystalball.friday.services.TaskService;

@RestController
public class TaskController 
{
	@Autowired
	TaskService taskService;
	
	@RequestMapping(value = "/tasks")
	public List<TaskEntity> getTasks()
	{
		return taskService.getAllTask();
	}
	
	@RequestMapping(value = "/createtask", method = RequestMethod.POST)
    public TaskEntity createTask(@Valid @RequestBody TaskEntity taskEntity) 
	{
        return taskService.createTask(taskEntity);
    }
 
    @RequestMapping(value = "/deletetask/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTask(@PathVariable(value = "id") Long id) 
    {
        return taskService.deleteTask(id);
    }
 
    @RequestMapping(value = "/updatetask/{id}", method = RequestMethod.PUT)
    public TaskEntity updateTask(@PathVariable(value = "id") Long id,
            @Valid @RequestBody TaskEntity taskEntity) 
    {
        return taskService.updateTask(id, taskEntity);
    }
}
