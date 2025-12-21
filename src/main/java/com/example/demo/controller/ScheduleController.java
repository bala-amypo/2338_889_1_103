package com.example.demo.controller;

import com.example.demo.model.GeneratedShiftSchedule;
import com.example.demo.service.ScheduleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/schedules")
@Tag(name = "Shift Schedules", description = "Shift Schedules Endpoints")
public class ScheduleController {
    
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/generate/{date}")
    @Operation(summary = "Generate schedule for date")
    public ResponseEntity<List<GeneratedShiftSchedule>> generate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.generateForDate(date));
    }

    @GetMapping("/date/{date}")
    @Operation(summary = "Get schedule for date")
    public ResponseEntity<List<GeneratedShiftSchedule>> getByDate(@PathVariable LocalDate date) {
        return ResponseEntity.ok(scheduleService.getByDate(date));
    }
}