package com.example.EmployeeMaster.Controller;


import com.example.EmployeeMaster.Dtos.RequestDto.EmpRequestDto;
import com.example.EmployeeMaster.Models.Employee;
import com.example.EmployeeMaster.Services.EmployeeService;
import jakarta.persistence.Entity;
import jakarta.ws.rs.core.NewCookie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.rsa.crypto.RsaKeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

   @PostMapping("/save")
   public ResponseEntity save(@RequestBody EmpRequestDto empRequestDto)throws Exception{
       try{
           String response = employeeService.save(empRequestDto);
           return new ResponseEntity(response,HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
       }
   }

    @GetMapping("/get/{empCode}")
    public ResponseEntity getByTransId(@PathVariable String empCode ){
        Employee employee = employeeService.getEmployee(empCode);
        return new ResponseEntity(employee,HttpStatus.OK);
    }


    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return employeeService.getAll();

    }


    @PutMapping("/update")
    public ResponseEntity Update(@RequestBody EmpRequestDto empRequestDto)throws Exception{
        try{
            String response = employeeService.update(empRequestDto);
            return new ResponseEntity(response,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

//
//    @CrossOrigin
//    @GetMapping("total")
//    public int getTotal(){
//      return employeeService.getTotal();
//    }

    @DeleteMapping("/delete/{empCode}")
    public ResponseEntity deleteEmployee(@PathVariable String empCode)throws Exception{
       try {
           String response = employeeService.delete(empCode);
           return new ResponseEntity(response,HttpStatus.OK);
       }
       catch(Exception e){
           return new ResponseEntity(e.getMessage(),HttpStatus.BAD_GATEWAY);
       }
    }

    @GetMapping("/nameList")
    public List<String> nameList(){
       return employeeService.nameList();
    }

    



}
