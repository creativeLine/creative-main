package com.example.Attendence.Controller;


import com.example.Attendence.Dtos.RequestDto.DayDto;
import com.example.Attendence.Service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Days")
public class DayController {

    @Autowired
    private DayService dayService;




    @PostMapping("/add")
    public ResponseEntity save(@RequestBody DayDto request)throws Exception{
        try{
            dayService.save(request);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


}
