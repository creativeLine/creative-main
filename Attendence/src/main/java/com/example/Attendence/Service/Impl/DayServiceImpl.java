package com.example.Attendence.Service.Impl;
import com.example.Attendence.Dtos.RequestDto.DayDto;
import com.example.Attendence.Exception.notPresent;
import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Models.Day;
import com.example.Attendence.Models.Month;
import com.example.Attendence.Repository.AttendanceRepository;
import com.example.Attendence.Repository.MonthRepository;
import com.example.Attendence.Service.DayService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


//@S/lf4j
@Service
public class DayServiceImpl implements DayService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private MonthRepository monthRepository;



    @Override
    public void save(DayDto request) throws Exception {


        Optional<Attendance> optionalAttendance=attendanceRepository.findByEmpCode(request.getEmpCode());
        if(optionalAttendance.isEmpty()){
            throw new notPresent("Invalid");
        }
        Attendance attendance = optionalAttendance.get();

        List<Month> monthList = attendance.getMonthList();
        Month month = new Month();
        for(Month m:monthList){
            if(m.getMonthName().equals(request.getMonthName())  && m.getMonthId().equals(request.getMonthId()) && m.getEmpCode().equals(request.getEmpCode())){
                month = m;
                break;
            }
        }

        Day day =new Day();

        day.setDate(request.getDate());
        day.setEmpCode(request.getEmpCode());

        day.setMonth(month);
        month.getDayList().add(day);
        monthRepository.save(month);
    }
}
