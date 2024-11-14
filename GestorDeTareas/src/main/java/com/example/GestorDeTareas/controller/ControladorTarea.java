package com.example.GestorDeTareas.controller;


import com.example.GestorDeTareas.model.Tarea;
import com.example.GestorDeTareas.service.ServicioTarea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class ControladorTarea {

    @Autowired
    private ServicioTarea servicioTarea;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea tareaCreada = servicioTarea.crearTarea(tarea);
        return ResponseEntity.ok(tareaCreada);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> obtenerTodasLasTareas() {
        List<Tarea> tareas = servicioTarea.obtenerTodasLasTareas();
        return ResponseEntity.ok(tareas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarea> obtenerTareaPorId(@PathVariable Long id) {
        return servicioTarea.obtenerTareaPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        Tarea tareaActualizada = servicioTarea.actualizarTarea(id, tarea.getTitulo());
        return ResponseEntity.ok(tareaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        servicioTarea.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}