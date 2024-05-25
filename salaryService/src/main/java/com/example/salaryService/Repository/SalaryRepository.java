package com.example.salaryService.Repository;

import com.example.salaryService.Models.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SalaryRepository extends JpaRepository<Salary,Integer> {
    Optional<Salary> findByEmpCode(String empCode);
}
