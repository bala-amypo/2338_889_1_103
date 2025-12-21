package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.ShiftTemplate;

import java.util.Optional;
import java.util.List;

@Repository
public interface ShiftTemplateRepository extends JpaRepository<ShiftTemplate,Long>
{
    Optional<ShiftTemplate>findByTemplateNameAndDepartment_Id(String name , Long id);
    List<ShiftTemplate> findByDepartment_Id(Long id);
    List<ShiftTemplate> findAll();
}
