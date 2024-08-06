package com.uisrael.springboot_proyecto.controller;


import com.uisrael.springboot_proyecto.entities.Tables;
import com.uisrael.springboot_proyecto.repositories.TablesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TablesController {
    @Autowired
    TablesRepository tablesRepository;

    ////Metodo Get
    @GetMapping("/tables")
    public List<Tables> tables(){return tablesRepository.findAll();}

    ///Metodo Post
    @PostMapping("/tables")
    public Tables crear(@RequestBody Tables tables){ return tablesRepository.save(tables);}

    ///Metodo Editar
    @GetMapping("/tables/{id}")
    public Optional<Tables> getTableById(@PathVariable Integer id){return tablesRepository.findById(id);}

    ///Metodo Delete
    @DeleteMapping("/tables/{id}")
    public ResponseEntity<Boolean> eliminarTable(@PathVariable int id){
        Optional <Tables> tables = tablesRepository.findById(id);
        tablesRepository.delete(tables.get());
        return ResponseEntity.ok(true);
    }

    ////Metodo put
    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> actualizarCourse(@PathVariable long id, @RequestBody Course courseData){
        Optional<Course> opcionalCourse = courseRepository.findById(id);

        if (opcionalCourse.isPresent()) {
            Course course = opcionalCourse.get();
            //actualizar
            course.setCourseName(courseData.getCourseName());
            course.setDescription(courseData.getDescription());
            course.setCredits(courseData.getCredits());

            Course courseGuardado = courseRepository.save(course);
            return ResponseEntity.ok(courseGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/classrooms/{id}")
    public ResponseEntity<Classroom> actualizarClassroom(@PathVariable long id, @RequestBody Classroom classroomData){
        Optional<Classroom> opcionalClassroom = classroomRepository.findById(id);

        if (opcionalClassroom.isPresent()) {
            Classroom classroom = opcionalClassroom.get();
            //actualizar
            classroom.setRoomNumber(classroomData.getRoomNumber());
            classroom.setCapacity(classroomData.getCapacity());
            classroom.setCourse(classroomData.getCourse());

            Classroom classroomGuardado = classroomRepository.save(classroom);
            return ResponseEntity.ok(classroomGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/teachers/{id}")
    public ResponseEntity<Teacher> actualizarTeacher(@PathVariable long id, @RequestBody Teacher teacherData){
        Optional<Teacher> opcionalTeacher = teacherRepository.findById(id);

        if (opcionalTeacher.isPresent()) {
            Teacher teacher = opcionalTeacher.get();
            //actualizar
            teacher.setFirstName(teacherData.getFirstName());
            teacher.setLastName(teacherData.getLastName());
            teacher.setEmail(teacherData.getEmail());
            teacher.setSpecialization(teacherData.getSpecialization());

            Teacher teacherGuardado = teacherRepository.save(teacher);
            return ResponseEntity.ok(teacherGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/estudiantes/{id}")
    public ResponseEntity<Estudiantes> actualizarEstudiante(@PathVariable long id, @RequestBody Estudiantes estudianteData){
        Optional<Estudiantes> opcionalEstudiante = estudiantesRepository.findById(id);

        if (opcionalEstudiante.isPresent()) {
            Estudiantes estudiante = opcionalEstudiante.get();
            //actualizar
            estudiante.setFirstName(estudianteData.getFirstName());
            estudiante.setLastName(estudianteData.getLastName());
            estudiante.setDateOfBirth(estudianteData.getDateOfBirth());
            estudiante.setEmail(estudianteData.getEmail());

            Estudiantes estudianteGuardado = estudiantesRepository.save(estudiante);
            return ResponseEntity.ok(estudianteGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/enrollments/{id}")
    public ResponseEntity<Enrollments> actualizarEnrollment(@PathVariable long id, @RequestBody Enrollments enrollmentData){
        Optional<Enrollments> opcionalEnrollment = enrollmentsRepository.findById(id);

        if (opcionalEnrollment.isPresent()) {
            Enrollments enrollment = opcionalEnrollment.get();
            //actualizar
            enrollment.setStudent(enrollmentData.getStudent());
            enrollment.setCourse(enrollmentData.getCourse());
            enrollment.setEnrollmentDate(enrollmentData.getEnrollmentDate());

            Enrollments enrollmentGuardado = enrollmentsRepository.save(enrollment);
            return ResponseEntity.ok(enrollmentGuardado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
