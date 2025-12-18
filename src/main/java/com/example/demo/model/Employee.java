package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
public class Employee{
    @Id
    private Long id;
    private String fullName;
     @Column(unique=true)
    private String email;
    private String ADMIN;
    private String STAFF;
    private String skills;
    @Min(1)
    private Int maxWeeklyHours;
    private LocalDateTime createdAt;

}