package com.uisrael.springboot_proyecto.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity

    @Table(name = "tbl_estudiantes")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Estudiantes {
        @Id
        @GeneratedValue( strategy = GenerationType.AUTO)
        private long student_id;
        private String first_name;
        private String last_name;
        private String date_of_birth;
        private String email;
}
