package com.example.Attendence.Service.Impl;


import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;

import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;


@Service
public class AttendanceServiceImpl implements AttendanceService {


    private RestTemplate restTemplate;

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Method to generate attendance for an employee
    @Override
    public void generateAttendance(String empCode) throws Exception {
        // Check if the employee exists
//        Optional optionalEmployee = restTemplate.getForObject("EMPLOYEE-MASTER/employee/get/" + empCode, Optional.class);
//        if (optionalEmployee.isEmpty()) {
//            throw new notPresent("The employee is not present");
//        }

        // Check if attendance for the employee already exists
//        Optional<Attendance> optionalAttendance = attendanceRepository.findByEmpCode(empCode);
//        if (optionalAttendance.isPresent()) {
//            throw new RuntimeException("Invalid");
//        }

        // Create a new attendance record for the employee
        Attendance attendance = new Attendance();
        attendance.setEmpCode(empCode);
        attendanceRepository.save(attendance);
    }

    // Method to get attendance for an employee
    @Override
    public Attendance getAttendance(String empCode) throws Exception {
        // Retrieve attendance for the employee
        Optional<Attendance> optionalAttendance = attendanceRepository.findByEmpCode(empCode);

        // If attendance does not exist, throw an exception
        if (optionalAttendance.isEmpty()) {
            throw new notPresent("Invalid");
        }

        return optionalAttendance.get();
    }
}
