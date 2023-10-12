package com.example.courseschedule.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id")
    private int gradeId;

    @Column(name = "grade_name")
    private String gradeName;

    // Constructors, getters, setters
}
