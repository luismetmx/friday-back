package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.crystalball.friday.entities.ExecutionTaskEntity;;

@Repository
public interface ExecutionTaskRepository extends JpaRepository<ExecutionTaskEntity, Long>{

}