package com.football.teams.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * Objeto de transferencia para Team.
 * Sólo expone id, name y city.
 */
public record TeamDto(
        Long id,

        @NotBlank(message = "El nombre del equipo es obligatorio")
        @Size(max = 100, message = "El nombre no puede exceder 100 caracteres")
        String name,

        @NotBlank(message = "La ciudad es obligatoria")
        @Size(max = 100, message = "La ciudad no puede exceder 100 caracteres")
        String city
) { }
