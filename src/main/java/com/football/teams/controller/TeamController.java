package com.football.teams.controller;

import com.football.teams.dto.TeamDto;
import com.football.teams.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

/**
 * API REST para gestionar equipos.
 */
@RestController
@RequestMapping("/api/teams")
@Validated
public class TeamController {

    private final TeamService svc;

    public TeamController(TeamService svc) {
        this.svc = svc;
    }

    /** Lista todos los equipos */
    @GetMapping
    public List<TeamDto> getAll() {
        return svc.findAll();
    }

    /** Crea un equipo nuevo */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TeamDto create(@Valid @RequestBody TeamDto dto) {
        return svc.create(dto);
    }

    /** Obtiene un equipo por ID */
    @GetMapping("/{id}")
    public TeamDto getOne(@PathVariable Long id) {
        return svc.findById(id);
    }

    /** Actualiza un equipo existente */
    @PutMapping("/{id}")
    public TeamDto update(
            @PathVariable Long id,
            @Valid @RequestBody TeamDto dto
    ) {
        return svc.update(id, dto);
    }

    /** Elimina un equipo */
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        svc.delete(id);
    }
}
