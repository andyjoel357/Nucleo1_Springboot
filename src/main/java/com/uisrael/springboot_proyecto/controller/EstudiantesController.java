package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Estudiantes;
import com.uisrael.springboot_proyecto.repositories.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EstudiantesController {
    @Autowired
    EstudiantesRepository estudiantesRepository;

    ////Metodo Get
    @GetMapping("/estudiantes")
    public List<Estudiantes> estudiantes(){return estudiantesRepository.findAll();}

    ///Metodo Post
    @PostMapping("/estudiantes")
    public Estudiantes crear(@RequestBody Estudiantes estudiantes){ return estudiantesRepository.save(estudiantes);}

    ///Metodo Editar
    @GetMapping("/estudiantes/{id}")
    public Optional<Estudiantes> getEstudiantesById(@PathVariable Integer id){return estudiantesRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Boolean> eliminarEstudiante(@PathVariable int id){
        Optional <Estudiantes> estudiantes = estudiantesRepository.findById(id);
        estudiantesRepository.delete(estudiantes.get());
        return ResponseEntity.ok(true);
    }
    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiantes> actualizarEstudiante(@PathVariable int id, @RequestBody Estudiantes estudianteData){
        Optional<Estudiantes> opcionalEstudiante = estudiantesRepository.findById(id);

        if (opcionalEstudiante.isPresent()) {
            Estudiantes estudiante = opcionalEstudiante.get();
            //actualizar
            estudiante.setFirst_name(estudianteData.getFirst_name());
            estudiante.setLast_name(estudianteData.getLast_name());
            estudiante.setDate_of_birth(estudianteData.getDate_of_birth());
            estudiante.setEmail(estudianteData.getEmail());

            Estudiantes estudianteGuardado = estudiantesRepository.save(estudiante);
            return ResponseEntity.ok(estudianteGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
