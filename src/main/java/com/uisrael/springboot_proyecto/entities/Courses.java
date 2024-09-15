package com.uisrael.springboot_proyecto.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tbl_courses")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Courses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Course_id", columnDefinition = "BIGINT")
    private Long Course_id;

    @Column(name = "course_name")
    private String course_name;

    @Column(name = "description")
    private String description;

    @Column(name = "credits")
    private int credits;
}