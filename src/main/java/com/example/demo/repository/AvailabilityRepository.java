package com.example.demo.repository;

import com.example.demo.model.EmployeeAvailability;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AvailabilityRepository {
    Optional<EmployeeAvailability> findByEmployee_IdAndAvailableDate(Long employeeId, LocalDate availableDate);
    List<EmployeeAvailability> findByAvailableDateAndAvailable(LocalDate availableDate, Boolean available);
    List<EmployeeAvailability> findByEmployee_Id(Long employeeId);
    EmployeeAvailability save(EmployeeAvailability availability);
    Optional<EmployeeAvailability> findById(Long id);
    void delete(EmployeeAvailability availability);
}