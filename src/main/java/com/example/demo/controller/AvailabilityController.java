package com.example.demo.controller;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.service.AvailabilityService;
import com.example.demo.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/availability")
public class AvailabilityController {
    
    private final AvailabilityService availabilityService;
    private final EmployeeService employeeService;

    public AvailabilityController(AvailabilityService availabilityService, EmployeeService employeeService) {
        this.availabilityService = availabilityService;
        this.employeeService = employeeService;
    }

    @PostMapping("/{employeeId}")
    public ResponseEntity<EmployeeAvailability> create(@PathVariable Long employeeId, @RequestBody EmployeeAvailability availability) {
        availability.setEmployee(employeeService.getEmployee(employeeId));
        return ResponseEntity.ok(availabilityService.create(availability));
    }

    @GetMapping("/employee/{employeeId}")
    public ResponseEntity<List<EmployeeAvailability>> getByEmployee(@PathVariable Long employeeId) {
        return ResponseEntity.ok(availabilityService.getByEmployee(employeeId));
    }

    @GetMapping("/{availabilityId}")
    public ResponseEntity<EmployeeAvailability> getById(@PathVariable Long availabilityId) {
        return ResponseEntity.ok(availabilityService.getById(availabilityId));
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<EmployeeAvailability>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(availabilityService.getByDate(date));
    }
}