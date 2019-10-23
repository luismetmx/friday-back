package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.crystalball.friday.entities.SolutionEntity;

@Repository
public interface SolutionRepository extends JpaRepository<SolutionEntity, Integer>
{
    
}
