package com.football.teams.service;

import com.football.teams.dto.TeamDto;
import java.util.List;

/**
 * Contrato de la lógica de negocio para Teams.
 */
public interface TeamService {
    List<TeamDto> findAll();
    TeamDto findById(Long id);
    TeamDto create(TeamDto dto);
    TeamDto update(Long id, TeamDto dto);
    void delete(Long id);
}
