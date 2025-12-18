package com.example.demo.model;


import jakarta.persistence.Id;
public class Employee{
    @Id
    private Long id;
    private String fullName;
    private String ADMIN;
    private String STAFF;
    private String skills;
    private Int maxWeeklyHours;

}