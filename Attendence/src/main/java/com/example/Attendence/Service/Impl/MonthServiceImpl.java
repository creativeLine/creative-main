package com.example.Attendence.Service.Impl;

import com.example.Attendence.Dtos.RequestDto.MonthDto;
import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Models.Month;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Repository.MonthRepository;
import com.example.Attendence.Service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MonthServiceImpl implements MonthService {

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private AttendanceRepository attendanceRepository;



    @Override
    public void save(MonthDto request) throws Exception {

        Month month = new Month();
        month.setMonthName(request.getMonthName());
        month.setEmpCode(request.getEmpCode());

        Optional<Attendance> optionalAttendance=attendanceRepository.findByEmpCode(request.getEmpCode());
        if(optionalAttendance.isEmpty()){
            throw new notPresent("Invalid");
        }
        Attendance attendance = optionalAttendance.get();
        attendance.getMonthList().add(month);
        month.setAttendance(attendance);

        attendanceRepository.save(attendance);
    }
}
