package com.uisrael.springboot_proyecto.repositories;


import com.uisrael.springboot_proyecto.entities.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudiantesRepository extends JpaRepository<Estudiantes,Integer> {
}
