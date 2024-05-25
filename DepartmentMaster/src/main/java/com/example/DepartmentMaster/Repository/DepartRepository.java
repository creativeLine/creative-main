package com.example.DepartmentMaster.Repository;

import com.example.DepartmentMaster.Models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartRepository extends JpaRepository<Department,Integer> {
}
