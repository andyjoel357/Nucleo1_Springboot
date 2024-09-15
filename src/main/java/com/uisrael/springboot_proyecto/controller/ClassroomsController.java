package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Classrooms;
import com.uisrael.springboot_proyecto.repositories.ClassroomsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClassroomsController {
    @Autowired
    ClassroomsRepository classroomsRepository;

    ////Metodo Get
    @GetMapping("/classrooms")
    public List<Classrooms> classrooms(){return classroomsRepository.findAll();}

    ///Metodo Post
    @PostMapping("/classrooms")
    public Classrooms crear(@RequestBody Classrooms classrooms){ return classroomsRepository.save(classrooms);}

    ///Metodo Editar
    @GetMapping("/classrooms/{id}")
    public Optional<Classrooms> getClassroomsById(@PathVariable Integer id){return classroomsRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/classrooms/{id}")
    public ResponseEntity<Boolean> eliminarClassroom(@PathVariable int id){
        Optional <Classrooms> classrooms = classroomsRepository.findById(id);
        classroomsRepository.delete(classrooms.get());
        return ResponseEntity.ok(true);
    }

    ///mwthodo Put
    @PutMapping("/classrooms/{id}")
    public ResponseEntity<Classrooms> actualizarClassrooms(@PathVariable int id, @RequestBody Classrooms classroomData){
        Optional<Classrooms> opcionalClassrooms = classroomsRepository.findById(id);

        if (opcionalClassrooms.isPresent()) {
            Classrooms classrooms = opcionalClassrooms.get();
            //actualizar
            classrooms.setRoom_number(classroomData.getRoom_number());
            classrooms.setCapacity(classroomData.getCapacity());
            classrooms.setCourse(classroomData.getCourse());

            Classrooms classroomGuardado = classroomsRepository.save(classrooms);
            return ResponseEntity.ok(classroomGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
