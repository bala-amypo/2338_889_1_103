package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
public class Department{
    @Id
    private Long id;
    @Column(unique=true)
    private String name;
    private String description;
    @Min()
    private String requiredSkills;
    private LocalDateTime createdAt;
     

}