package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "Password is required")
    @Size(min = 8,message="Password must be at least 8 characters")
    private String password;

    @Column(nullable = false)
    @NotNull(message = "Role is required")
    @Enumerated(EnumType.STRING)
    private Role role = Role.ANALYST;

    public enum Role 
    {
        ADMIN,
        ANALYST
    }

    //Constructors
    public User(){}

    public User(String name , String email , String password , Role role)
    {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    //Getters
    public Long getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public Role getRole()
    {
        return role;
    }

    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public void setRole(Role role)
    {
        this.role = role;
    }

}
