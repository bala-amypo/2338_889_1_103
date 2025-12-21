package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "employees")
public class Employee{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "Full name is required")
    private String fullName;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be valid")
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role = Role.STAFF;

    public enum Role 
    {
        ADMIN,
        STAFF
    }

    @Column(nullable = false)
    private String skills;

    @Column(nullable = false)
    @NotNull(message = "Max weekly hours is required")
    @Min(value = 1,message = "Max weekly hours must be greater than 0")
    private Integer maxWeeklyHours;

    @Column(nullable = false , updatable = false)
    @NotNull
    private LocalDateTime createdAt;

    //Relationships
    @OneToMany(mappedBy ="employee",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<EmployeeAvailability> availabilities;

    @OneToMany(mappedBy ="employee",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<GeneratedShiftSchedule> generatedShifts;

    //Constructors
    public Employee(){}

    public Employee(String fullName , String email , Role role , String skills , Integer maxWeeklyHours)
    {
        this.fullName = fullName;
        this.email = email;
        this.role = role;
        this.skills = skills;
        this.maxWeeklyHours = maxWeeklyHours;
    }
    @PrePersist
    protected void onCreate() 
    {  
        this.createdAt=LocalDateTime.now();
    } 
    //Getters
    public Long getId() 
    {
        return id;
    }
    public String getFullName()
    {
        return fullName; 
    }
    public String getEmail()
    {
        return email;
    }
    public Role getRole()
    {
        return role;
    }
    public String getSkills()
    {
        return skills;
    }
    //Skills passed as comma-separated values returns as Set<String>
    public Set<String> getSkillsSet()
    {
        Set<String>skillSet = new HashSet<>();
        if(skills == null || skills.trim().isEmpty())
        {
            return skillSet;
        }
        String[] parts = skills.split(",");
        for(String part : parts)
        {
            String trimmed = part.trim();
            if(!trimmed.isEmpty())
            {
                skillSet.add(trimmed);
            } 
        }
        return skillSet;
    }
    public Integer getMaxWeeklyHours()
    {
        return maxWeeklyHours;
    }
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }
    public List<EmployeeAvailability> getAvailabilities()
    {
        return availabilities;
    }
    public List<GeneratedShiftSchedule> getGeneratedShifts()
    {
        return generatedShifts;
    }

    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public void setRole(Role role)
    {
        this.role = role;
    }
    public void setSkills(String skills)
    {
        this.skills = skills;
    }
    public void setMaxWeeklyHours(Integer maxWeeklyHours)
    {
        this.maxWeeklyHours = maxWeeklyHours;
    }
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt=LocalDateTime.now();
    }
    public void setAvailabilities(List<EmployeeAvailability> availabilities)
    {
        this.availabilities = availabilities;
    }
    public void setGeneratedShifts(List<GeneratedShiftSchedule> generatedShifts)
    {
        this.generatedShifts = generatedShifts;
    }
}
