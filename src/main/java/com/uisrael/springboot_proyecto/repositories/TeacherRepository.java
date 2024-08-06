package com.uisrael.springboot_proyecto.repositories;

import com.uisrael.springboot_proyecto.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
