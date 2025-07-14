package com.football.teams.repository;

import com.football.teams.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * CRUD básico para la entidad Team.
 */
@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
}
