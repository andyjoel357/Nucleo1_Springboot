package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Enrollments;
import com.uisrael.springboot_proyecto.repositories.EnrollmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EnrollmentsController {
    @Autowired
    EnrollmentsRepository enrollmentsRepository;

    ////Metodo Get
    @GetMapping("/enrollments")
    public List<Enrollments> enrollments(){return enrollmentsRepository.findAll();}

    ///Metodo Post
    @PostMapping("/enrollments")
    public Enrollments crear(@RequestBody Enrollments enrollments){ return enrollmentsRepository.save(enrollments);}

    ///Metodo Editar
    @GetMapping("/enrollments/{id}")
    public Optional<Enrollments> getEnrollmentById(@PathVariable Integer id){return enrollmentsRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/enrollments/{id}")
    public ResponseEntity<Boolean> eliminarEnrollment(@PathVariable int id){
        Optional <Enrollments> enrollments = enrollmentsRepository.findById(id);
        enrollmentsRepository.delete(enrollments.get());
        return ResponseEntity.ok(true);
    }
    ///Methodo PUT
    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollments> actualizarEnrollment(@PathVariable int id, @RequestBody Enrollments enrollmentData){
        Optional<Enrollments> opcionalEnrollment = enrollmentsRepository.findById(id);

        if (opcionalEnrollment.isPresent()) {
            Enrollments enrollment = opcionalEnrollment.get();
            //actualizar
            enrollment.setStudent_id(enrollmentData.getStudent_id());
            enrollment.setCourse(enrollmentData.getCourse());
            enrollment.setEnrollment_date(enrollmentData.getEnrollment_date());

            Enrollments enrollmentGuardado = enrollmentsRepository.save(enrollment);
            return ResponseEntity.ok(enrollmentGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
