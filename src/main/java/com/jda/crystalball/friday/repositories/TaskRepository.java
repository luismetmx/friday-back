package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.crystalball.friday.entities.SolutionEntity;
import com.jda.crystalball.friday.entities.TaskEntity;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Long>{
    List<TaskEntity> findByIsActiveTrueAndProjectTypeAndPhaseAndSolutionEntity(String type, String phase, SolutionEntity solution);
}
