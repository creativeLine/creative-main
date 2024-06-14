package com.example.Attendence.Service.Impl;


import com.example.Attendence.Dtos.ResponseDto.monthlyResponseDto;
import com.example.Attendence.Enum.Status;
import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;

import com.example.Attendence.Models.Day;
import com.example.Attendence.Models.Month;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Service.AttendanceService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


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

    @Override
    public Map<String,Integer> getPresentEmployee(String date) throws Exception {

        List<Attendance> attendanceList = attendanceRepository.findAll();
        String currMonth = "may";
        int currDay = 1;
        int countp =0;
        int countab = 0;
        int countl= 0;
        Map<String,Integer> map = new HashMap<>();

        for(Attendance attendance:attendanceList){

            List<Month> monthList = attendance.getMonthList();
            for(Month month:monthList){
                if(currMonth.equals(month.getMonthName())){
                    List<Day> daylist = month.getDayList();
                    for(Day day :daylist){
                        if(day.getDayId().equals(currDay)){

                             if(day.getStatus().equals(Status.PP)) countp++;

                             if(day.getStatus().equals(Status.AA)) countab++;

                             if(day.getStatus().equals(Status.NN)) countl++;


                        }
                    }
                }
            }
        }

        map.put("Present",countp);
        map.put("Absent",countab);
        map.put("Unknown",countl);



        return map;
    }

    @Override
    public monthlyResponseDto getMonthlyattendance(String empCode, String monthName) throws Exception {
        Optional<Attendance> optionalAttendance = attendanceRepository.findByEmpCode(empCode);

        optionalAttendance.get();
        return null;

    }
}
