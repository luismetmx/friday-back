package com.jda.crystalball.friday.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.jda.crystalball.friday.entities.ResourcesEntity;
import com.jda.crystalball.friday.repositories.ResourcesRepository;

@Service
public class ResourcesService 
{
	@Autowired
	ResourcesRepository resourcesRepository;
	
	public List<ResourcesEntity> getAllResources()
	{
		return (List<ResourcesEntity>) resourcesRepository.findAll();
	}
	
	public ResourcesEntity createResource(ResourcesEntity resource)
	{
		return resourcesRepository.save(resource);
	}
	
	public ResourcesEntity updateResource(Long Id, ResourcesEntity resource)
	{
		ResourcesEntity updatedResource;
		Optional<ResourcesEntity> searchEntity = resourcesRepository.findById(Id);
		
		if (searchEntity.isPresent()) 
		{
			ResourcesEntity sample = searchEntity.get();
            sample.setMail(resource.getMail());
            sample.setName(resource.getName());
            sample.setSolutionEntity(resource.getSolutionEntity());
            updatedResource = resourcesRepository.save(sample);
        } 
		else
		{
            throw new EntityNotFoundException();
        }
        return updatedResource;
	}
	
	public ResponseEntity<Object> deleteResource(Long Id)
	{
        Optional<ResourcesEntity> sampleEntity = resourcesRepository.findById(Id);
        if (sampleEntity.isPresent()) 
        {
        	ResourcesEntity sample = sampleEntity.get();
        	resourcesRepository.delete(sample);
        } 
        else 
        {
            throw new EntityNotFoundException();
        }
        return ResponseEntity.ok().build();
    }
}
