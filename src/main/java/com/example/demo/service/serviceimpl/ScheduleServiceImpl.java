package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.ScheduleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;

@Service
@Transactional
public class ScheduleServiceImpl implements ScheduleService {
    
    private final ShiftTemplateRepository shiftTemplateRepository;
    private final AvailabilityRepository availabilityRepository;
    private final EmployeeRepository employeeRepository;
    private final GeneratedShiftScheduleRepository generatedShiftScheduleRepository;

    //Constructor
    public ScheduleServiceImpl(ShiftTemplateRepository shiftTemplateRepository,
                              AvailabilityRepository availabilityRepository,
                              EmployeeRepository employeeRepository,
                              GeneratedShiftScheduleRepository generatedShiftScheduleRepository) 
    {
        this.shiftTemplateRepository = shiftTemplateRepository;
        this.availabilityRepository = availabilityRepository;
        this.employeeRepository = employeeRepository;
        this.generatedShiftScheduleRepository = generatedShiftScheduleRepository;
    }

    //Methods
    @Override
    public List<GeneratedShiftSchedule> generateForDate(LocalDate date) 
    {
        List<GeneratedShiftSchedule> generatedSchedules = new ArrayList<>();
        List<ShiftTemplate> allTemplates = shiftTemplateRepository.findAll();
        List<EmployeeAvailability> availableEmployees = availabilityRepository.findByAvailableDateAndAvailable(date, true);

        for (ShiftTemplate template : allTemplates) 
        {
            Employee assignedEmployee = findQualifiedEmployee(template, availableEmployees);
            
            if (assignedEmployee != null) 
            {
                GeneratedShiftSchedule schedule = new GeneratedShiftSchedule();
                schedule.setShiftDate(date);
                schedule.setStartTime(template.getStartTime());
                schedule.setEndTime(template.getEndTime());
                schedule.setShiftTemplate(template);
                schedule.setDepartment(template.getDepartment());
                schedule.setEmployee(assignedEmployee);
                
                generatedSchedules.add(generatedShiftScheduleRepository.save(schedule));
            }
        }
        
        return generatedSchedules;
    }

    private Employee findQualifiedEmployee(ShiftTemplate template, List<EmployeeAvailability> availableEmployees) 
    {
        Set<String> requiredSkills = template.getRequiredSkillsSet();
        
        for (EmployeeAvailability availability : availableEmployees) 
        {
            Employee employee = availability.getEmployee();
            Set<String> employeeSkills = employee.getSkillsSet();
            
            // Check if employee has all required skills
            if (employeeSkills.containsAll(requiredSkills)) 
            {
                return employee;
            }
        }
        
        return null; // No qualified employee found
    }

    @Override
    public List<GeneratedShiftSchedule> getByDate(LocalDate date) 
    {
        return generatedShiftScheduleRepository.findByShiftDate(date);
    }
}