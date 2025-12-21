package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "shift_templates", uniqueConstraints = @UniqueConstraint(columnNames = {"templateName","department_id"}))
public class ShiftTemplate{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Template name is required")
    private String templateName;

    @Column(nullable = false)
    @NotNull(message = "Start time is required")
    private LocalTime startTime;

    @Column(nullable = false)
    @NotNull(message = "End time is required")
    private LocalTime endTime;

    @Column
    private String requiredSkills;

    //Relationships
    @OneToMany(mappedBy ="shiftTemplate",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<GeneratedShiftSchedule> generatedShifts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
    @NotNull(message = "Department is required")
    private Department department;

    //Constructors
    public ShiftTemplate(){
    }

    public ShiftTemplate(String templateName , LocalTime startTime , LocalTime endTime , String requiredSkills , Department department)
    {
        this.templateName = templateName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.requiredSkills = requiredSkills;
        this.department = department;

    }

    @PrePersist
    @PreUpdate
    private void validateTimes()
    {
        if(endTime != null && startTime !=null)
        {
            if(endTime.isBefore(startTime)||endTime.equals(startTime))
            {
                throw new IllegalArgumentException("End time must be after start time");
            }
        }
    }

    //Getters
    public Long getId() 
    {
        return id;
    }
    public String getTemplateName()
    {
        return templateName;
    }
    public LocalTime getStartTime()
    {
        return startTime; 
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
    public String getRequiredSkills()
    {
        return requiredSkills;
    }
    
    public Set<String> getRequiredSkillsSet() {
        Set<String> skillSet = new HashSet<>();
        if (requiredSkills == null || requiredSkills.trim().isEmpty()) {
            return skillSet;
        }
        String[] parts = requiredSkills.split(",");
        for (String part : parts) {
            String trimmed = part.trim();
            if (!trimmed.isEmpty()) {
                skillSet.add(trimmed);
            }
        }
        return skillSet;
    }
    public Department getDepartment()
    {
        return department;
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
    public void setTemplateName(String templateName)
    {
        this.templateName = templateName;
    }
    public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }
    public void setRequiredSkills(String requiredSkills)
    {
        this.requiredSkills = requiredSkills;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public void setGeneratedShifts(List<GeneratedShiftSchedule> generatedShifts)
    {
        this.generatedShifts = generatedShifts;
    }
 }

