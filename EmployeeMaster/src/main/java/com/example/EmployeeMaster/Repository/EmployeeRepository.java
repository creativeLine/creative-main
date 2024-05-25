package com.example.EmployeeMaster.Repository;

import com.example.EmployeeMaster.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmpCode(String empCode);
}
