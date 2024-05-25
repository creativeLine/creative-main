package com.example.Attendence.Controller;


import com.example.Attendence.Dtos.RequestDto.MonthDto;
import com.example.Attendence.Service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/month")
public class MonthController {


    @Autowired
    private MonthService monthService;


    @PostMapping("/addMonth")
    public ResponseEntity addMonth(@RequestBody MonthDto request) throws Exception{
        try{
            monthService.save(request);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.CONFLICT);
        }

    }
}
