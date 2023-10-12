package com.example.courseschedule.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Experiment")
public class Experiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "experiment_id")
    private int experimentId;

    @Column(name = "experiment_name")
    private String experimentName;

    @Column(name = "experiment_type")
    private String experimentType;

    @Column(name = "hours")
    private int hours;

    // Constructors, getters, setters
}
