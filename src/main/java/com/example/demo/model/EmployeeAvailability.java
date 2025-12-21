package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "employee_availability",uniqueConstraints = @UniqueConstraint(columnNames = {"employee_id","available_date"}))
public class EmployeeAvailability{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    @NotNull(message = "Employee is required")
    private Employee employee;

    @Column(nullable = false , name = "available_date")
    @NotNull(message = "Available Date is required")
    private LocalDate availableDate;

    @Column(nullable = false)
    @NotNull(message = "Available status is required")
    private Boolean available = true;

    //Constructors
    public EmployeeAvailability(){
    }

    public EmployeeAvailability(Employee employee , LocalDate availableDate , Boolean available)
    {
        this.employee = employee;
        this.availableDate = availableDate;
        this.available = available;
    }

    //Getters
    public Long getId() 
    {
        return id;
    }
    public Employee getEmployee()
    {
        return employee; 
    }
    public LocalDate getAvailableDate()
    {
        return availableDate;
    }
    public Boolean getAvailable()
    {
        return available;
    }
    //Setters
    public void setId(Long id)
    {
        this.id = id;
    }
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
    public void setAvailableDate( LocalDate availableDate)
    {
        this.availableDate = availableDate;
    }
    public void setAvailable(Boolean available)
    {
        this.available = available;
    }
}
