package com.valeriaignacio.FixNow.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class IncidenciaDTO {

    @NotBlank(message = "La descripción es obligatoria")
    @Size(min = 5, max = 200, message = "La descripción debe tener entre 5 y 200 caracteres")
    private String descripcion;

    @NotBlank(message = "El usuario es obligatorio")
    @Size(min = 2, max = 50, message = "El usuario debe tener entre 2 y 50 caracteres")
    private String usuario;

    @NotBlank(message = "El estado es obligatorio")
    @Pattern(regexp = "ABIERTA|EN_PROGRESO|RESUELTA", 
        message = "El estado debe ser: ABIERTA, EN_PROGRESO o RESUELTA")
    private String estado;

    @NotBlank(message = "La prioridad es obligatoria")
    @Pattern(regexp = "ALTA|MEDIA|BAJA", 
        message = "La prioridad debe ser: ALTA, MEDIA o BAJA")
    private String prioridad;
}