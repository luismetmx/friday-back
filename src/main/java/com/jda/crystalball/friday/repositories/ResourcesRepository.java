package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.crystalball.friday.entities.ResourcesEntity;

@Repository
public interface ResourcesRepository extends JpaRepository<ResourcesEntity, Long>
{

}
