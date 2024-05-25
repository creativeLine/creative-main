package com.example.DepartmentMaster.Controller;


import com.example.DepartmentMaster.Dtos.RequestDto;
import com.example.DepartmentMaster.Models.Department;
import com.example.DepartmentMaster.Service.DepartService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartController {


    @Autowired
    private DepartService departService;

    // Create operation
    @PostMapping("/create")
    public String createDepartment(@RequestBody RequestDto department) {
        return departService.createDepartment(department);
    }

    // Read operation
    @GetMapping("/get/{departId}")
    @CircuitBreaker(name="employeeSalaryBreaker", fallbackMethod = "employeeSalaryFallback")
    public Department getDepartmentById(@PathVariable Integer departId) {
        return departService.getDepartmentById(departId);
    }

    public Department employeeSalaryFallback(Integer departId){
        Department department = Department.builder().departName("abc").build();
        return department   ;
    }

    // Read operation
    @GetMapping("/get/all")
    public List<Department> getAllDepartments() {
        return departService.getAllDepartments();
    }

    // Update operation
    @PutMapping("/update/{departId}")
    public String updateDepartment(@PathVariable Integer departId, @RequestBody Department department) {
        return departService.updateDepartment(departId, department);
    }

    // Delete operation
    @DeleteMapping("/delete/{departId}")
    public String deleteDepartment(@PathVariable Integer departId) {
        return departService.deleteDepartment(departId);
    }


    @GetMapping("/calculateSalary")
    public ResponseEntity calculate(@RequestParam String empCode, @RequestParam String monthName)throws Exception{
        try{
            Double response = departService.calculateService(empCode,monthName);
            return new ResponseEntity(response, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }
}