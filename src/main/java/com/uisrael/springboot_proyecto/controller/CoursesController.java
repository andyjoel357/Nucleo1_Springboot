package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Courses;
import com.uisrael.springboot_proyecto.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepository;

    //// Método Get - Listar cursos
    @GetMapping
    public String listCourses(Model model) {
        List<Courses> courses = coursesRepository.findAll();
        model.addAttribute("courses", courses);
        return "courses";  // Página HTML para listar cursos (en la raíz de templates)
    }

    //// Método Get - Mostrar formulario para agregar curso nuevo
    @GetMapping("/nuevo")
    public String showNewForm(Model model) {
        model.addAttribute("courses", new Courses());
        return "courses_nuevo";  // Página HTML para nuevo curso (en la raíz de templates)
    }

    //// Método Post - Guardar curso nuevo
    @PostMapping("/courses")
    public String createCourse(@ModelAttribute Courses course, Model model) {
        coursesRepository.save(course);
        return "redirect:/courses";  // Redirigir a la lista de cursos
    }

    //// Método Get - Mostrar formulario para editar curso
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Courses> courseExistente = coursesRepository.findById(id);
        if (courseExistente.isPresent()) {
            model.addAttribute("courses", courseExistente.get());
        } else{}
        return "course_editar";  // Página HTML para editar curso (en la raíz de templates)
    }

    //// Método Post - Actualizar curso
    @PutMapping("/editar/{id}")
    public String updateCourse(@PathVariable int id, @ModelAttribute Courses course, Model model) {
        Optional<Courses> courseExistente = coursesRepository.findById(id);
        if (courseExistente.isPresent()) {
            Courses curso = courseExistente.get();
            curso.setCourse_name(course.getCourse_name());
            curso.setDescription(course.getDescription());
            curso.setCredits(course.getCredits());
            coursesRepository.save(curso);
        }
        return "redirect:/courses";  // Redirigir a la lista de cursos después de la edición
    }

// Método Delete - Eliminar curso
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable Integer id) {
        coursesRepository.deleteById(id);
        return "redirect:/courses";  // Redirigir a la lista después de eliminar
    }
}