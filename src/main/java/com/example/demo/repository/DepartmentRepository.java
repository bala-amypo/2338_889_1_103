package com.example.demo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Department;

public interface UserRepository extends JpaRepository<Department,Long>{

}