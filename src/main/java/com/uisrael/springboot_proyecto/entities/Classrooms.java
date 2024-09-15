package com.uisrael.springboot_proyecto.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "tbl_classrooms")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classrooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classrooms_id")
    private Long classrooms_id;

    @Column(name = "room_number")
    private String room_number;

    @Column(name = "capacity")
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "course_id", referencedColumnName = "Course_id", columnDefinition = "BIGINT")
    private Courses course;
}