package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import com.jda.crystalball.friday.entities.ExecutionTaskEntity;;

@Repository
public interface ExecutionTaskRepository extends JpaRepository<ExecutionTaskEntity, Long>{

    public List<ExecutionTaskEntity> findByStatus(String status);

}