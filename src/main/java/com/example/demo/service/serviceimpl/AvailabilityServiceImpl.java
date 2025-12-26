package com.example.demo.service.impl;

import com.example.demo.model.EmployeeAvailability;
import com.example.demo.repository.AvailabilityRepository;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.AvailabilityService;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;

    public AvailabilityServiceImpl(AvailabilityRepository availabilityRepository,
                                  EmployeeRepository employeeRepository) {
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeAvailability create(EmployeeAvailability availability) {
        if (availability.getEmployee() != null && availability.getEmployee().getId() != null) {
            employeeRepository.findById(availability.getEmployee().getId())
                    .orElseThrow(() -> new RuntimeException("Employee not found"));
            
            if (availability.getAvailableDate() != null) {
                availabilityRepository.findByEmployee_IdAndAvailableDate(
                        availability.getEmployee().getId(),
                        availability.getAvailableDate()
                ).ifPresent(a -> {
                    throw new RuntimeException("Availability already exists for this date");
                });
            }
        }
        
        return availabilityRepository.save(availability);
    }

    @Override
    public EmployeeAvailability update(Long id, EmployeeAvailability availability) {
        EmployeeAvailability existing = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        
        if (availability.getAvailable() != null) {
            existing.setAvailable(availability.getAvailable());
        }
        
        if (availability.getAvailableDate() != null) {
            existing.setAvailableDate(availability.getAvailableDate());
        }
        
        return availabilityRepository.save(existing);
    }

    @Override
    public void delete(Long id) {
        EmployeeAvailability availability = availabilityRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Availability not found"));
        availabilityRepository.delete(availability);
    }

    @Override
    public List<EmployeeAvailability> getByDate(LocalDate date) {
        return availabilityRepository.findByAvailableDateAndAvailable(date, true);
    }
}