package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Department;

import java.util.Optional;
import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>
{
    Optional<Department>findById(Long id);
    boolean existsByName(String name);
    List<Department> findAll();
}
