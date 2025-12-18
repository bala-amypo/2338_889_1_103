package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.EmployeeAvailability;

public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability,Long>{

}