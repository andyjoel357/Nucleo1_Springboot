package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Courses;
import com.uisrael.springboot_proyecto.repositories.CoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/courses")
public class CoursesController {
    @Autowired
    CoursesRepository coursesRepository;

    @GetMapping
    public String courses(Model model) {
        model.addAttribute("courses", coursesRepository.findAll());
        return "courses"; // returns the courses.html template
    }

    @GetMapping("/new")
    public String newCourse(Model model) {
        model.addAttribute("course", new Courses());
        return "Aula_nueva"; // returns the Aula_nueva.html template
    }

    @PostMapping
    public String crear(@ModelAttribute Courses course) {
        coursesRepository.save(course);
        return "redirect:/courses"; // redirects to the courses list
    }

    @GetMapping("/{id}")
    public String getCoursesById(@PathVariable int id, Model model) {
        model.addAttribute("course", coursesRepository.findById(id).orElseThrow());
        return "editar"; // returns the editar.html template
    }

    @PutMapping("/{id}")
    public String actualizarCourse(@PathVariable int id, @ModelAttribute Courses courseData) {
        Courses course = coursesRepository.findById(id).orElseThrow();
        course.setCourse_name(courseData.getCourse_name());
        course.setDescription(courseData.getDescription());
        course.setCredits(courseData.getCredits());
        coursesRepository.save(course);
        return "redirect:/courses"; // redirects to the courses list
    }

    @GetMapping("/delete/{id}")
    public String eliminarCourses(@PathVariable int id) {
        coursesRepository.deleteById(id);
        return "redirect:/courses"; // redirects to the courses list
    }
}