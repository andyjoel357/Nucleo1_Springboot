package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Courses;
import com.uisrael.springboot_proyecto.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepository;

    ////Metodo Get
    @GetMapping("/courses")
    public List<Courses> courses(){return coursesRepository.findAll();}

    ///Metodo Post
    @PostMapping("/courses")
    public Courses crear(@RequestBody Courses courses){ return coursesRepository.save(courses);}

    ///Metodo Editar
    @GetMapping("/courses/{id}")
    public Optional<Courses> getCoursesById(@PathVariable Integer id){return coursesRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Boolean> eliminarCourses(@PathVariable int id){
        Optional <Courses>courses = coursesRepository.findById(id);
        coursesRepository.delete(courses.get());
        return ResponseEntity.ok(true);
    }
    @PutMapping("/courses/{id}")
    public ResponseEntity<Courses> actualizarCourse(@PathVariable int id, @RequestBody Courses courseData){
        Optional<Courses> opcionalCourses = coursesRepository.findById(id);

        if (opcionalCourses.isPresent()) {
            Courses courses = opcionalCourses.get();
            //actualizar
            courses.setCourse_name(courseData.getCourse_name());
            courses.setDescription(courseData.getDescription());
            courses.setCredits(courseData.getCredits());

            Courses courseGuardado = coursesRepository.save(courses);
            return ResponseEntity.ok(courseGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
