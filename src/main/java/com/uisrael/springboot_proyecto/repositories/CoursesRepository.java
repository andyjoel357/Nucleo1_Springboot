package com.uisrael.springboot_proyecto.repositories;

import com.uisrael.springboot_proyecto.entities.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository <Courses,Integer> {
}
