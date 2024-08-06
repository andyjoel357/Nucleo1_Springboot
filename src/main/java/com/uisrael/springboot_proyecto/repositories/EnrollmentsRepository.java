package com.uisrael.springboot_proyecto.repositories;

import com.uisrael.springboot_proyecto.entities.Enrollments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentsRepository extends JpaRepository<Enrollments,Integer> {
}
