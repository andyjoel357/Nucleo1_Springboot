package com.uisrael.springboot_proyecto.repositories;

import com.uisrael.springboot_proyecto.entities.Classrooms;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <Classrooms,Integer>{
}
