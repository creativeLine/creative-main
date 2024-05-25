package com.example.Attendence.Service;

import com.example.Attendence.Models.Attendance;

public interface AttendanceService {

    void generateAttendance(String empCode) throws Exception;

    Attendance getAttendance(String empCode) throws Exception;
}
