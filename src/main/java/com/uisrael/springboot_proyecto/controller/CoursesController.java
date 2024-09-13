package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Courses;
import com.uisrael.springboot_proyecto.entities.Enrollments;
import com.uisrael.springboot_proyecto.entities.Estudiantes;
import com.uisrael.springboot_proyecto.repositories.CoursesRepository;
import com.uisrael.springboot_proyecto.repositories.EnrollmentsRepository;
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
    public String createCourse(@ModelAttribute Courses course) {
        return "redirect:Cursos.html"; // Redirect to the course list page
    }
    ///Metodo Editar
    @GetMapping("/courses/{id}")
    public Optional<Courses> getCoursesById(@PathVariable Integer id){return coursesRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Boolean> eliminarCourses(@PathVariable int id){
        Optional <Courses> courses = coursesRepository.findById(id);
        coursesRepository.delete(courses.get());
        return ResponseEntity.ok(true);
    }
    ///Methodo PUT
    @PutMapping("/courses/{id}")
    public ResponseEntity<Courses> actualizarCourses(@PathVariable int id, @RequestBody Courses coursesData){
        Optional<Courses> opcionalCourses = coursesRepository.findById(id);

        if (opcionalCourses.isPresent()) {
            Courses courses = opcionalCourses.get();
            //actualizar
            courses.setCourse_name(coursesData.getCourse_name());
            courses.setDescription(coursesData.getDescription());
            courses.setCredits(coursesData.getCredits());

            Courses coursesGuardado = coursesRepository.save(courses);
            return ResponseEntity.ok(coursesGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
