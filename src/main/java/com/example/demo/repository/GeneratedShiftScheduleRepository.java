package com.example.demo.repository;

import com.example.demo.model.GeneratedShiftSchedule;
import java.time.LocalDate;
import java.util.List;

public interface GeneratedShiftScheduleRepository {
    List<GeneratedShiftSchedule> findByShiftDate(LocalDate shiftDate);
    GeneratedShiftSchedule save(GeneratedShiftSchedule schedule);
}