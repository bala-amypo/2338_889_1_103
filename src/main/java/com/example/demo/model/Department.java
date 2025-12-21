package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import jakarta.validation.constraints.*;
import java.util.List;

@Entity
@Table(name = "departments")
public class Department{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false , unique = true)
    @NotBlank(message = "Department name is required")
    private String name;

    @Column
    private String description;

    @Column
    private String requiredSkills;

    @Column(nullable = false , updatable = false)
    @NotNull
    private LocalDateTime createdAt;

    //Relationships
    @OneToMany(mappedBy ="department",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<ShiftTemplate> shiftTemplates;

    @OneToMany(mappedBy ="department",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<GeneratedShiftSchedule> generatedShifts;

    //Constructors
    public Department(){
        this.createdAt=LocalDateTime.now();
    }

    public Department(String name , String description , String requiredSkills)
    {
        this.name = name;
        this.description = description;
        this.requiredSkills = requiredSkills;
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
    public String getName()
    {
        return name; 
    }
    public String getDescription()
    {
        return description;
    }
    public String getRequiredSkills()
    {
        return requiredSkills;
    }
    public LocalDateTime getCreatedAt()
    {
        return createdAt;
    }
    public List<ShiftTemplate> getShiftTemplates()
    {
        return shiftTemplates;
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
    public void setName(String name)
    {
        this.name = name;
    }
    public void setDescription(String description)
    {
        this.description = description;
    }
    public void setRequiredSkills(String requiredSkills)
    {
        this.requiredSkills = requiredSkills;
    }
    public void setCreatedAt(LocalDateTime createdAt)
    {
        this.createdAt = createdAt;
    }
    public void setShiftTemplates(List<ShiftTemplate> shiftTemplates)
    {
        this.shiftTemplates = shiftTemplates;
    }
    public void setGeneratedShifts(List<GeneratedShiftSchedule> generatedShifts)
    {
        this.generatedShifts = generatedShifts;
    }
}