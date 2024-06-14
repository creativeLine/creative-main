package com.example.Attendence.Service;

import com.example.Attendence.Dtos.ResponseDto.monthlyResponseDto;
import com.example.Attendence.Models.Attendance;

import java.util.Date;
import java.util.Map;

public interface AttendanceService {

    void generateAttendance(String empCode) throws Exception;

    Attendance getAttendance(String empCode) throws Exception;

    Map<String,Integer> getPresentEmployee(String  date)throws Exception;

    monthlyResponseDto getMonthlyattendance(String empCode, String monthName)throws Exception;
}
