package com.example.Attendence.Repository;

import com.example.Attendence.Models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance,Integer> {
//    Optional<Attendance> findByEmpCode(String empCode);
    Optional<Attendance> findByEmpCode(String empCode);
}
