package com.example.GestorDeTareas.service;

import com.example.GestorDeTareas.model.Tarea;
import com.example.GestorDeTareas.repository.RepositorioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioTarea {

    @Autowired
    private RepositorioTarea repositorioTarea;

    public Tarea crearTarea(Tarea tarea) {
        return repositorioTarea.guardar(tarea);
    }

    public List<Tarea> obtenerTodasLasTareas() {
        return repositorioTarea.obtenerTodas();
    }

    public Optional<Tarea> obtenerTareaPorId(Long id) {
        return repositorioTarea.obtenerPorId(id);
    }

    public Tarea actualizarTarea(Long id, String titulo) {
        return repositorioTarea.actualizar(id, titulo);
    }

    public void eliminarTarea(Long id) {
        repositorioTarea.eliminar(id);
    }
}