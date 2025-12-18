package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
public class User{
    @Id
    private Long id;
    private string name;
    @Column(unique=true)
    private string email;
    private string password;
    private string ADMIN;
    private string ANALYST;
}