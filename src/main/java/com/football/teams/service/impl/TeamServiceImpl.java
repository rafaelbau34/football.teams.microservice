package com.football.teams.service.impl;

import com.football.teams.dto.TeamDto;
import com.football.teams.entity.Team;
import com.football.teams.exception.ResourceNotFoundException;
import com.football.teams.repository.TeamRepository;
import com.football.teams.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación de TeamService.
 * Se encarga de mapear entidad ↔ DTO y lanzar excepciones.
 */
@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository repo;

    public TeamServiceImpl(TeamRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<TeamDto> findAll() {
        return repo.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TeamDto findById(Long id) {
        Team t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team con id " + id + " no encontrado"));
        return toDto(t);
    }

    @Override
    public TeamDto create(TeamDto dto) {
        Team t = new Team();
        t.setName(dto.name());
        t.setCity(dto.city());
        return toDto(repo.save(t));
    }

    @Override
    public TeamDto update(Long id, TeamDto dto) {
        Team t = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team con id " + id + " no encontrado"));
        t.setName(dto.name());
        t.setCity(dto.city());
        return toDto(repo.save(t));
    }

    @Override
    public void delete(Long id) {
        if (!repo.existsById(id)) {
            throw new ResourceNotFoundException("Team con id " + id + " no encontrado");
        }
        repo.deleteById(id);
    }

    private TeamDto toDto(Team t) {
        return new TeamDto(t.getId(), t.getName(), t.getCity());
    }
}
