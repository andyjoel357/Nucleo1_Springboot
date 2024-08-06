package com.uisrael.springboot_proyecto.repositories;

import com.uisrael.springboot_proyecto.entities.Classrooms;
import com.uisrael.springboot_proyecto.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomsRepository extends JpaRepository <Classrooms,Integer>{
}
