package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Classrooms;
import com.uisrael.springboot_proyecto.repositories.ClassroomsRepository;
import com.uisrael.springboot_proyecto.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/classrooms")
public class ClassroomsController {
    @Autowired
    ClassroomsRepository classroomsRepository;
    CoursesRepository coursesRepository;
    //// Método Get - Listar classrooms
    @GetMapping
    public String listClassrooms(Model model) {
        List<Classrooms> classrooms = classroomsRepository.findAll();
        model.addAttribute("classrooms", classrooms);
        return "classrooms";  // Página HTML para listar classrooms (en la raíz de templates)
    }

    //// Método Get - Mostrar formulario para agregar classroom nuevo
    @GetMapping("/nuevo")
    public String showNewForm(Model model) {
        model.addAttribute("classrooms", new Classrooms());
        return "classrooms_new";  // Página HTML para nuevo classroom (en la raíz de templates)
    }

    //// Método Post - Guardar classroom nuevo
    @PostMapping
    public String crear(@ModelAttribute Classrooms classrooms, Model model) {
        classroomsRepository.save(classrooms);
        return "redirect:/classrooms";  // Redirigir a la lista de classrooms
    }

    //// Método Get - Mostrar formulario para editar classroom
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Classrooms> classroomExistente = classroomsRepository.findById(id);
        if (classroomExistente.isPresent()) {
            model.addAttribute("classrooms", classroomExistente.get());
        } else {}
        return "classroom_editar";  // Página HTML para editar classroom (en la raíz de templates)
    }

    //// Método Post - Actualizar classroom
    @PostMapping("/editar/{id}")
    public String updateClassroom(@PathVariable int id, @ModelAttribute Classrooms classrooms, Model model) {
        Optional<Classrooms> classroomExistente = classroomsRepository.findById(id);
        if (classroomExistente.isPresent()) {
            Classrooms classroom = classroomExistente.get();
            classroom.setRoom_number(classrooms.getRoom_number());
            classroom.setCapacity(classrooms.getCapacity());
            classroom.setCourse(classrooms.getCourse());
            classroomsRepository.save(classroom);
        }
        return "redirect:/classrooms";  // Redirigir a la lista de classrooms después de la edición
    }

    //// Método Delete - Eliminar classroom
    @PostMapping("/{id}")
    public String deleteClassroom(@PathVariable Integer id, @RequestParam("_method") String method, Model model) {
        if (method.equals("delete")) {
            classroomsRepository.deleteById(id);
        }
        return "redirect:/classrooms";  // Redirigir a la lista después de eliminar
    }
}