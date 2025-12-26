package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    
    private final EmployeeRepository employeeRepository;
    
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    
    @Override
    public Employee createEmployee(Employee employee) {
        if (employee.getMaxHoursPerWeek() != null && employee.getMaxHoursPerWeek() <= 0) {
            throw new RuntimeException("Max hours must be greater than 0");
        }
        if (employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Employee with email already exists");
        }
        if (employee.getRole() == null) {
            employee.setRole("STAFF");
        }
        return employeeRepository.save(employee);
    }
    
    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    
    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee existing = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        
        if (!existing.getEmail().equals(employee.getEmail()) && 
            employeeRepository.existsByEmail(employee.getEmail())) {
            throw new RuntimeException("Employee with email already exists");
        }
        
        existing.setFullName(employee.getFullName());
        existing.setEmail(employee.getEmail());
        existing.setRole(employee.getRole());
        existing.setSkills(employee.getSkills());
        existing.setMaxHoursPerWeek(employee.getMaxHoursPerWeek());
        
        return employeeRepository.save(existing);
    }
    
    @Override
    public void deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        employeeRepository.delete(employee);
    }
    
    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
    }
    
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }
}