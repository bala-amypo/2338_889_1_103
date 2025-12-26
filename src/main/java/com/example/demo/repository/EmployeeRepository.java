package com.example.demo.repository;

import com.example.demo.model.Employee;
import java.util.Optional;
import java.util.List;

public interface EmployeeRepository {
    boolean existsByEmail(String email);
    Optional<Employee> findByEmail(String email);
    Employee save(Employee employee);
    Optional<Employee> findById(Long id);
    void delete(Employee employee);
    List<Employee> findAll();
}