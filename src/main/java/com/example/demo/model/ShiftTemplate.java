package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class ShiftTemplate{
    @Id
    private Long id;
     @Column(unique=true)
    private String templateName;
    private LocalTime startTime;
    private LocalTime endTime;
    private String requiredSkills;;
    private department;

}