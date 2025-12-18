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
    public User(Long id, string name, string email, string password, string aDMIN, string aNALYST) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        ADMIN = aDMIN;
        ANALYST = aNALYST;
    }
    public User() {
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public string getName() {
        return name;
    }
    public void setName(string name) {
        this.name = name;
    }
    public string getEmail() {
        return email;
    }
    public void setEmail(string email) {
        this.email = email;
    }
    public string getPassword() {
        return password;
    }
    public void setPassword(string password) {
        this.password = password;
    }
    public string getADMIN() {
        return ADMIN;
    }
    public void setADMIN(string aDMIN) {
        ADMIN = aDMIN;
    }
    public string getANALYST() {
        return ANALYST;
    }
    public void setANALYST(string aNALYST) {
        ANALYST = aNALYST;
    }
}