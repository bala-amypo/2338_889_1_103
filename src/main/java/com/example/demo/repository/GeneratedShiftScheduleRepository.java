package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.model.GeneratedShiftSchedule;

import java.util.List;
import java.time.LocalDate;

@Repository
public interface GeneratedShiftScheduleRepository extends JpaRepository<GeneratedShiftSchedule,Long>
{
    List<GeneratedShiftSchedule>findByShiftDate(LocalDate date);
    List<GeneratedShiftSchedule>findAll();
    
}
