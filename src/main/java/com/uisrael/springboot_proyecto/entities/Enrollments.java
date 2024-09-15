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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollment_id")
    private Long enrollmentId;

    @ManyToOne
    @JoinColumn(name = "Student_id", referencedColumnName = "Student_id")
    private Estudiantes Student_id;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "Course_id", columnDefinition = "BIGINT")
    private Courses course;

    @Column(name = "Enrollment_date")
    private String Enrollment_date;
}