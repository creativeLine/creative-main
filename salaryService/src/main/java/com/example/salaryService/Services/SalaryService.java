package com.example.salaryService.Services;

import com.example.salaryService.Dtos.RequestDto.SalaryRequestDto;
import com.example.salaryService.Models.Salary;

public interface SalaryService {
    String save(SalaryRequestDto salaryRequestDto);

    Salary get(String empCode) throws Exception;

    String update(SalaryRequestDto salaryRequestDto) throws Exception;


    Double getTotal(String empCode) throws Exception;
}
