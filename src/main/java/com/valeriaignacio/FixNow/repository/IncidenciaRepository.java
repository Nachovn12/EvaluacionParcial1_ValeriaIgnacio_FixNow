package com.valeriaignacio.FixNow.repository;

import com.valeriaignacio.FixNow.model.Incidencia;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class IncidenciaRepository {

    List<Incidencia> lista = new ArrayList<>();

    public Incidencia save(Incidencia incidencia) {
        lista.add(incidencia);
        return incidencia;
    }

    public List<Incidencia> findAll() {
        return lista;
    }

    public Incidencia findById(int id) {
        for (Incidencia i : lista) {
            if (i.getId() == id) {
                return i;
            }
        }
        return null;
    }

    public Incidencia update(int id, Incidencia nueva) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                nueva.setId(id);
                lista.set(i, nueva);
                return nueva;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == id) {
                lista.remove(i);
                return true;
            }
        }
        return false;
    }

    // Filtrar por estado
    public List<Incidencia> findByEstado(String estado) {
        List<Incidencia> filtradas = new ArrayList<>();
        for (Incidencia i : lista) {
            if (i.getEstado().equalsIgnoreCase(estado)) {
                filtradas.add(i);
            }
        }
        return filtradas;
    }
}