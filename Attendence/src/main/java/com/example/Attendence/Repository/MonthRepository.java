package com.example.Attendence.Repository;

import com.example.Attendence.Models.Month;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MonthRepository extends JpaRepository<Month,Integer> {
    Optional<Month> findMonthByMonthNameAndEmpCode(String monthName, String empCode);

    Optional<Month> findMonthByMonthNameAndMonthIdAndEmpCode(String monthName, Integer monthId, String empCode);
}
