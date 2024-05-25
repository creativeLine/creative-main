package com.example.Attendence.Controller;


import com.example.Attendence.Models.Attendance;
import com.example.Attendence.Service.AttendanceService;
import com.example.Attendence.Service.EntriesService;
import lombok.experimental.PackagePrivate;
import org.hibernate.internal.build.AllowPrintStacktrace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.cert.CertPathValidatorException;

@RestController
@RequestMapping("attendance")
public class AttendanceController {


    @Autowired
    private AttendanceService attendanceService;



    @PostMapping("generate")
    public ResponseEntity generateAttendance(@RequestParam String empCode) throws Exception{
        try{
             attendanceService.generateAttendance(empCode);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

    @GetMapping("get/{empCode}")
    public ResponseEntity getAttendance(@PathVariable String empCode) throws Exception{
       try{
           Attendance attendance = attendanceService.getAttendance(empCode);
           return new ResponseEntity(attendance,HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
       }
    }
}



