package com.uisrael.springboot_proyecto.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity

@Table(name = "tbl_enrollments")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Enrollments {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long enrollment_id;
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private String student_id;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private String course_id;

    private String enrollment_date;
}

