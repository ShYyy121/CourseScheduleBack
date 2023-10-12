package com.example.courseschedule.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Classroom")
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classroom_id")
    private int classroomId;

    @Column(name = "classroom_name")
    private String classroomName;

    @Column(name = "equipment_type")
    private String equipmentType;

    @Column(name = "equipment_count")
    private int equipmentCount;

    @Column(name = "capacity")
    private int capacity;

    // Constructors, getters, setters
}
