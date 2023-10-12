package com.example.courseschedule.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Preschedule")
public class PreSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "preschedule_id")
    private Integer preScheduleId;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class teachingClass;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    @Column(name = "week")
    private String week;

    @Column(name = "weekday")
    private String weekday;

    @Column(name = "period")
    private String period;

    // Constructors, getters, setters
}
