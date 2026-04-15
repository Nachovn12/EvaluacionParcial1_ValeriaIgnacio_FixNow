package com.valeriaignacio.FixNow.service;

import com.valeriaignacio.FixNow.model.Incidencia;
import com.valeriaignacio.FixNow.repository.IncidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    @Autowired
    private IncidenciaRepository repository;

    public Incidencia create(Incidencia incidencia) {
        return repository.save(incidencia);
    }

    public List<Incidencia> readAll() {
        return repository.findAll();
    }

    public Incidencia readById(int id) {
        return repository.findById(id);
    }

    public Incidencia update(int id, Incidencia incidenciaActualizada) {
        Incidencia existente = readById(id);
        
        if (existente == null) {
            return null;
        }

        incidenciaActualizada.setId(id);
        incidenciaActualizada.setFechaRegistro(existente.getFechaRegistro());
        
        return repository.update(id, incidenciaActualizada);
    }

    public boolean deleteById(int id) {
        return repository.deleteById(id);
    }

    public List<Incidencia> readByEstado(String estado) {
        return repository.findByEstado(estado);
    }
}