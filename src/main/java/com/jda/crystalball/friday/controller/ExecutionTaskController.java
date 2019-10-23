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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jda.crystalball.friday.entities.ExecutionTaskEntity;
import com.jda.crystalball.friday.services.ExecutionTaskService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ExecutionTaskController 
{
	@Autowired
	ExecutionTaskService ExecutionTaskService;
	
	@RequestMapping(value = "/executiontasks")
	public List<ExecutionTaskEntity> getExecutionTasks()
	{
		return ExecutionTaskService.getAllExecutionTasks();
    }
    
    @RequestMapping(value = "/executiontasksbystatus")
	public List<ExecutionTaskEntity> getExecutionTasksByStatus(@RequestParam String status)
	{
		return ExecutionTaskService.getExecutionTasksByStatus(status);
	}
	
	@RequestMapping(value = "/createexecutiontask", method = RequestMethod.POST)
    public ExecutionTaskEntity createExecutionTask(@Valid @RequestBody ExecutionTaskEntity ExecutionTaskEntity) 
	{
        return ExecutionTaskService.createExecutionTask(ExecutionTaskEntity);
    }
 
    @RequestMapping(value = "/deleteexecutiontask/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteexecutionTask(@PathVariable(value = "id") Long id) 
    {
        return ExecutionTaskService.deleteexecutionTask(id);
    }
 
    @RequestMapping(value = "/updateexecutiontask/{id}", method = RequestMethod.PUT)
    public ExecutionTaskEntity updateExecutionTask(@PathVariable(value = "id") Long id,
            @Valid @RequestBody ExecutionTaskEntity ExecutionTaskEntity) 
    {
        return ExecutionTaskService.updateExecutionTask(id, ExecutionTaskEntity);
    }
}
