package com.example.demo.repository;

import com.example.demo.model.ShiftTemplate;
import java.util.List;
import java.util.Optional;

public interface ShiftTemplateRepository {
    Optional<ShiftTemplate> findByTemplateNameAndDepartment_Id(String templateName, Long departmentId);
    List<ShiftTemplate> findByDepartment_Id(Long departmentId);
    ShiftTemplate save(ShiftTemplate shiftTemplate);
    List<ShiftTemplate> findAll();
}