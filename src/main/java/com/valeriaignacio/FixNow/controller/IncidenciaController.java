package com.valeriaignacio.FixNow.controller;

import com.valeriaignacio.FixNow.model.Incidencia;
import com.valeriaignacio.FixNow.model.IncidenciaDTO;
import com.valeriaignacio.FixNow.service.IncidenciaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    // Listar todas las incidencias
    @GetMapping
    public ResponseEntity<?> getIncidencias() {
        List<Incidencia> lista = incidenciaService.readAll();
        return ResponseEntity.ok(lista);
    }

    // Buscar una incidencia por su id
    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidenciaById(@PathVariable int id) {
        Incidencia incidencia = incidenciaService.readById(id);
        if (incidencia == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Incidencia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.ok(incidencia);
    }

    // Crear una nueva incidencia
    @PostMapping
    public ResponseEntity<?> postIncidencia(@Valid @RequestBody IncidenciaDTO dto) {
        Incidencia nueva = new Incidencia(
                dto.getDescripcion(),
                dto.getUsuario(),
                dto.getEstado(),
                dto.getPrioridad()
        );

        Incidencia creada = incidenciaService.create(nueva);

        return ResponseEntity.status(HttpStatus.CREATED).body(creada);
    }

    // Actualizar una incidencia existente
    @PutMapping("/{id}")
    public ResponseEntity<?> putIncidencia(@PathVariable int id, @Valid @RequestBody IncidenciaDTO dto) {
        Incidencia datos = new Incidencia(
                dto.getDescripcion(),
                dto.getUsuario(),
                dto.getEstado(),
                dto.getPrioridad()
        );

        Incidencia actualizada = incidenciaService.update(id, datos);
        if (actualizada == null) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Incidencia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }

        return ResponseEntity.ok(actualizada);
    }

    // Eliminar una incidencia
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteIncidencia(@PathVariable int id) {
        boolean eliminado = incidenciaService.deleteById(id);
        if (!eliminado) {
            Map<String, String> error = new HashMap<>();
            error.put("error", "Incidencia no encontrada");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
        return ResponseEntity.noContent().build();
    }

    // Filtrar por estado de la incidencia
    @GetMapping("/estado/{estado}")
    public ResponseEntity<?> getByEstado(@PathVariable String estado) {
        List<Incidencia> resultado = incidenciaService.readByEstado(estado);
        return ResponseEntity.ok(resultado);
    }
}