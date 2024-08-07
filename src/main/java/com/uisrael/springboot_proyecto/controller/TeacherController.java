package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Teacher;
import com.uisrael.springboot_proyecto.repositories.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TeacherController {
    @Autowired
    TeacherRepository teacherRepository;

    ////Metodo Get
    @GetMapping("/teacher")
    public List<Teacher> teachers(){return teacherRepository.findAll();}

    ///Metodo Post
    @PostMapping("/teacher")
    public Teacher crear(@RequestBody Teacher teacher){ return teacherRepository.save(teacher);}

    ///Metodo Editar
    @GetMapping("/teacher/{id}")
    public Optional<Teacher> getTeacherById(@PathVariable Integer id){return teacherRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/teacher/{id}")
    public ResponseEntity<Boolean> eliminarTeacher(@PathVariable int id){
        Optional <Teacher> teacher = teacherRepository.findById(id);
        teacherRepository.delete(teacher.get());
        return ResponseEntity.ok(true);
    }
    /// Metodo Put
    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> actualizarTeacher(@PathVariable int id, @RequestBody Teacher teacherData){
        Optional<Teacher> opcionalTeacher = teacherRepository.findById(id);

        if (opcionalTeacher.isPresent()) {
            Teacher teacher = opcionalTeacher.get();
            //actualizar
            teacher.setFirst_name(teacherData.getFirst_name());
            teacher.setLast_name(teacherData.getLast_name());
            teacher.setEmail(teacherData.getEmail());
            teacher.setSpecialization(teacherData.getSpecialization());
            Teacher teacherGuardado = teacherRepository.save(teacher);
            return ResponseEntity.ok(teacherGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
