package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "generated_shift_schedules")
public class GeneratedShiftSchedule{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotNull(message = "Shift Date is required")
    private LocalDate shiftDate;

    @Column(nullable = false)
    @NotNull(message = "Start Time is required")
    private LocalTime startTime;

    @Column(nullable = false)
    @NotNull(message = "End Time is required")
    private LocalTime endTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id",nullable = false)
    @NotNull(message = "Department is required")
    private Department department;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id",nullable = false)
    @NotNull(message = "Employee is required")
    private Employee employee;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_template_id",nullable = false)
    @NotNull(message = "Shift Template is required")
    private ShiftTemplate shiftTemplate;


    //Constructors
    public GeneratedShiftSchedule(){
        this.shiftDate=LocalDate.now();
    }

    public GeneratedShiftSchedule(LocalDate shiftDate , LocalTime startTime , LocalTime endTime , Department department ,  Employee employee , ShiftTemplate shiftTemplate )
    {
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.department = department;
        this.employee = employee;
        this.shiftTemplate = shiftTemplate;
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
    public LocalDate getShiftDate()
    {
        return shiftDate;
    }
     public LocalTime getStartTime()
    {
        return startTime; 
    }
    public LocalTime getEndTime()
    {
        return endTime;
    }
    public Department getDepartment()
    {
        return department;
    }
     public Employee getEmployee()
    {
        return employee; 
    }
    public ShiftTemplate getShiftTemplate()
    { 
        return shiftTemplate;

    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
     public void setShiftDate(LocalDate shiftDate)
    {
        this.shiftDate = shiftDate;
    }
     public void setStartTime(LocalTime startTime)
    {
        this.startTime = startTime;
    }
    public void setEndTime(LocalTime endTime)
    {
        this.endTime = endTime;
    }
    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
     public void setShiftTemplate(ShiftTemplate shiftTemplate)
    {
        this.shiftTemplate = shiftTemplate;
    }

}
