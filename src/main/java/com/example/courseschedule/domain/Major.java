package com.example.courseschedule.domain;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Major")
public class Major {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "major_code")
    private int majorCode;

    @Column(name = "major_name")
    private String majorName;

    // Constructors, getters, setters
}
