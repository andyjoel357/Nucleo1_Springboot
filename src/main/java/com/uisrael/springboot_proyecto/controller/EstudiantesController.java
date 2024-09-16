package com.uisrael.springboot_proyecto.controller;

import com.uisrael.springboot_proyecto.entities.Estudiantes;
import com.uisrael.springboot_proyecto.repositories.EstudiantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/estudiantes")
public class EstudiantesController {
    @Autowired
    EstudiantesRepository estudiantesRepository;

    //// Método Get - Listar estudiantes
    @GetMapping
    public String listEstudiantes(Model model) {
        List<Estudiantes> estudiantes = estudiantesRepository.findAll();
        model.addAttribute("estudiantes", estudiantes);
        return "estudiantes";  // Página HTML para listar estudiantes (en la raíz de templates)
    }

    //// Método Get - Mostrar formulario para agregar estudiante nuevo
    @GetMapping("/nuevo")
    public String showNewForm(Model model) {
        model.addAttribute("estudiantes", new Estudiantes());
        return "estudiante_nuevo";  // Página HTML para nuevo estudiante (en la raíz de templates)
    }

    //// Método Post - Guardar estudiante nuevo
    @PostMapping("/estudiantes")
    public String crear(@ModelAttribute Estudiantes estudiantes, Model model) {
        estudiantesRepository.save(estudiantes);
        return "redirect:/estudiantes";  // Redirigir a la lista de estudiantes
    }

    //// Método Get - Mostrar formulario para editar estudiante
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Estudiantes> estudianteExistente = estudiantesRepository.findById(id);
        if (estudianteExistente.isPresent()) {
            model.addAttribute("estudiantes", estudianteExistente.get());
        } else{}
        return "estudiante_editar";  // Página HTML para editar estudiante (en la raíz de templates)
    }

    //// Método Post - Actualizar estudiante
    @PostMapping("/editar/{id}")
    public String updateEstudiante(@PathVariable int id, @ModelAttribute Estudiantes estudiantes, Model model) {
        Optional<Estudiantes> estudianteExistente = estudiantesRepository.findById(id);
        if (estudianteExistente.isPresent()) {
            Estudiantes estudiante = estudianteExistente.get();
            estudiante.setFirst_name(estudiantes.getFirst_name());
            estudiante.setLast_name(estudiantes.getLast_name());
            estudiante.setDate_of_birth(estudiantes.getDate_of_birth());
            estudiante.setEmail(estudiantes.getEmail());
            estudiantesRepository.save(estudiante);
        }
        return "redirect:/estudiantes";  // Redirigir a la lista de estudiantes después de la edición
    }
    //// Método Delete - Eliminar estudiante
    @DeleteMapping("/{id}")
    public String deleteEstudiantes(@PathVariable Integer id, Model model) {
        estudiantesRepository.deleteById(id);
        return "redirect:/estudiantes";  // Redirigir a la lista después de eliminar
    }}
