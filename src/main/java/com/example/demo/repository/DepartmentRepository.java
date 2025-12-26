package com.example.demo.repository;

import com.example.demo.model.Department;
import java.util.Optional;
import java.util.List;

public interface DepartmentRepository {
    boolean existsByName(String name);
    Department save(Department department);
    Optional<Department> findById(Long id);
    void delete(Department department);
    List<Department> findAll();
}