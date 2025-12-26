package com.example.demo.dto;

import java.time.LocalDate;

public class AvailabilityDto {
    private Long employeeId;
    private LocalDate availableDate;
    private Boolean available;

    public AvailabilityDto() {}

    public AvailabilityDto(Long employeeId, LocalDate availableDate, Boolean available) {
        this.employeeId = employeeId;
        this.availableDate = availableDate;
        this.available = available;
    }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }
    
    public LocalDate getAvailableDate() { return availableDate; }
    public void setAvailableDate(LocalDate availableDate) { this.availableDate = availableDate; }
    
    public Boolean getAvailable() { return available; }
    public void setAvailable(Boolean available) { this.available = available; }
}