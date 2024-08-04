package com.uisrael.springboot_proyecto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "tbl_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long courses_id;
    private String course_name;
    private String description;
    private int credits;
}