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

import com.jda.crystalball.friday.entities.ResourcesEntity;
import com.jda.crystalball.friday.services.ResourcesService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ResourcesController 
{
	@Autowired
	ResourcesService resourcesService;
	
	@RequestMapping(value = "/resources")
	public List<ResourcesEntity> getResources()
	{
		return resourcesService.getAllResources();
	}
	
	@RequestMapping(value = "/createresource", method = RequestMethod.POST)
    public ResourcesEntity createResource(@Valid @RequestBody ResourcesEntity resourceEntity) 
	{
        return resourcesService.createResource(resourceEntity);
    }
 
    @RequestMapping(value = "/deleteresource/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteResource(@PathVariable(value = "id") Long id) 
    {
        return resourcesService.deleteResource(id);
    }
 
    @RequestMapping(value = "/updateresource/{id}", method = RequestMethod.PUT)
    public ResourcesEntity updateResource(@PathVariable(value = "id") Long id,
            @Valid @RequestBody ResourcesEntity resourceEntity) 
    {
        return resourcesService.updateResource(id, resourceEntity);
    }
}
