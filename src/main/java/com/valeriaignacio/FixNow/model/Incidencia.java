package com.valeriaignacio.FixNow.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

@Data
@NoArgsConstructor
public class Incidencia {

    private static final AtomicInteger contador = new AtomicInteger(1);

    private int id;
    private String descripcion;
    private String usuario;
    private String estado;
    private String prioridad;
    private LocalDate fechaRegistro;

    public Incidencia(String descripcion, String usuario, String estado, String prioridad) {
        this.id = contador.getAndIncrement();
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaRegistro = LocalDate.now();
    }
}