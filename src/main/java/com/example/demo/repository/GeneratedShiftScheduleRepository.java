package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.GeneratedShiftSchedule;

public interface UserRepository extends JpaRepository<GeneratedShiftSchedule,Long>{

}