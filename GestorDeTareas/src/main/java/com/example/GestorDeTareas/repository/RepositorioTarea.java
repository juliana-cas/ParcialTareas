package com.example.GestorDeTareas.repository;


import com.example.GestorDeTareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RepositorioTarea {

    private List<Tarea> tareas = new ArrayList<>();
    private Long idActual = 1L;

    public Tarea guardar(Tarea tarea) {
        tarea.setId(idActual++);
        tareas.add(tarea);
        return tarea;
    }

    public List<Tarea> obtenerTodas() {
        return tareas;
    }

    public Optional<Tarea> obtenerPorId(Long id) {
        return tareas.stream().filter(tarea -> tarea.getId().equals(id)).findFirst();
    }

    public Tarea actualizar(Long id, String titulo) {
        Tarea tarea = obtenerPorId(id).orElseThrow(() -> new RuntimeException("Tarea no encontrada"));
        tarea.setTitulo(titulo);
        return tarea;
    }

    public void eliminar(Long id) {
        tareas.removeIf(tarea -> tarea.getId().equals(id));
    }
}