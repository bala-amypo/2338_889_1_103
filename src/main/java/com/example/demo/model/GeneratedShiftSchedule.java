package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class GeneratedShiftSchedule {
    private Long id;
    private Employee employee;
    private ShiftTemplate shiftTemplate;
    private LocalDate shiftDate;
    private LocalTime startTime;
    private LocalTime endTime;

    public GeneratedShiftSchedule() {}

    public GeneratedShiftSchedule(Employee employee, ShiftTemplate shiftTemplate, LocalDate shiftDate, LocalTime startTime, LocalTime endTime) {
        this.employee = employee;
        this.shiftTemplate = shiftTemplate;
        this.shiftDate = shiftDate;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    
    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
    
    public ShiftTemplate getShiftTemplate() { return shiftTemplate; }
    public void setShiftTemplate(ShiftTemplate shiftTemplate) { this.shiftTemplate = shiftTemplate; }
    
    public LocalDate getShiftDate() { return shiftDate; }
    public void setShiftDate(LocalDate shiftDate) { this.shiftDate = shiftDate; }
    
    public LocalTime getStartTime() { return startTime; }
    public void setStartTime(LocalTime startTime) { this.startTime = startTime; }
    
    public LocalTime getEndTime() { return endTime; }
    public void setEndTime(LocalTime endTime) { this.endTime = endTime; }
}