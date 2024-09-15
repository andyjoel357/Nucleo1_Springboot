package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Estudiantes;
import com.uisrael.springboot_proyecto.repositories.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class EstudiantesController {
    @Autowired
    EstudiantesRepository estudiantesRepository;

    ////Metodo Get
    @GetMapping("/estudiantes")
    public List<Estudiantes> estudiantes(){return estudiantesRepository.findAll();}

    ///Metodo Post
    @GetMapping("/estudiantes/form")
    public String student(Model model){
        model.addAttribute("estudiante", new Estudiantes());
        List<Estudiantes> estudiante = estudiantesRepository.findAll();
        model.addAttribute("estudiante", estudiante);
        return "estudiante/student";
    }
    @PostMapping("/estudiantes")
    public ResponseEntity<Estudiantes> crear(@RequestBody Estudiantes estudiantes){
        Estudiantes savedEstudiante = estudiantesRepository.save(estudiantes);
        return ResponseEntity.ok(savedEstudiante);
    }


    ///Metodo Editar
    @GetMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiantes> getEstudiante(@PathVariable Integer id) {
        Optional<Estudiantes> optionalEstudiante = estudiantesRepository.findById(id);
        if (optionalEstudiante.isPresent()) {
            return ResponseEntity.ok(optionalEstudiante.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    ///Metodo Update
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

    ///Metodo Delete
    @DeleteMapping("/estudiantes/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Integer id) {
        Optional<Estudiantes> optionalEstudiante = estudiantesRepository.findById(id);
        if (optionalEstudiante.isPresent()) {
            estudiantesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}