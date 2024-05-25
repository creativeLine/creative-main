package com.example.salaryService.Controller;


import com.example.salaryService.Dtos.RequestDto.SalaryRequestDto;
import com.example.salaryService.Models.Salary;
import com.example.salaryService.Services.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {


    @Autowired
    private SalaryService salaryService;


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody SalaryRequestDto salaryRequestDto){

            String response = salaryService.save(salaryRequestDto);
            return new ResponseEntity(response, HttpStatus.CREATED);
    }


    @GetMapping("/get/{empCode}")
    public ResponseEntity get(@PathVariable String empCode)throws Exception{
        try{
            Salary response = salaryService.get(empCode);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);

        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }



    @PutMapping("/update")
    public ResponseEntity update(@RequestBody SalaryRequestDto salaryRequestDto)throws Exception{
       try{
           String response = salaryService.update(salaryRequestDto);
           return new ResponseEntity(response,HttpStatus.ACCEPTED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
       }
    }


    @GetMapping("/getTotal/{empCode}")
    public ResponseEntity getTotal(@PathVariable String empCode) throws Exception{
        try{
            Double response = salaryService.getTotal(empCode);
            return new ResponseEntity(response,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
