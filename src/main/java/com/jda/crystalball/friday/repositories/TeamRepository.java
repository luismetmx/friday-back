package com.jda.crystalball.friday.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jda.crystalball.friday.entities.TeamEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Integer>{

}
