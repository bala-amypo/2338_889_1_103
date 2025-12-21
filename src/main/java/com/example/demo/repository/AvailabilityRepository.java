package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.EmployeeAvailability;

import java.time.LocalDate;
import java.util.Optional;
import java.util.List;

@Repository
public interface AvailabilityRepository extends JpaRepository<EmployeeAvailability,Long>
{
    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long id , LocalDate date);
    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate date, boolean available);
    List<EmployeeAvailability> findByEmployee_Id(Long id);
    List<EmployeeAvailability> findAll();
}
