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
    @GeneratedValue( strategy = GenerationType.AUTO)
    private long classrooms_id;
    private String room_number;
    private int capacity;
    @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    private String course_id;
}

