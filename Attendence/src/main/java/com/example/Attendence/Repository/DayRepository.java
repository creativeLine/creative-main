package com.example.Attendence.Repository;

import com.example.Attendence.Models.Day;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DayRepository extends JpaRepository<Day, Integer> {
    Optional<Day> findByMonthMonthNameAndDayIdAndEmpCode(String monthName, Integer dayId, String empCode);

    Optional<Day> findByDayIdAndEmpCode(Integer dayId, String empCode);
}
