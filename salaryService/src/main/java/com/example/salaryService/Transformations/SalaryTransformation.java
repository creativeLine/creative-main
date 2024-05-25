package com.example.salaryService.Transformations;

import com.example.salaryService.Dtos.RequestDto.SalaryRequestDto;
import com.example.salaryService.Models.Salary;

public class SalaryTransformation {



    public static Salary convertEntity(SalaryRequestDto requestDto){
        Salary salary = Salary.builder()
                .empCode(requestDto.getEmpCode())
                .hra(requestDto.getHra())
                .basicPay(requestDto.getBasicPay())
                .convenience(requestDto.getConvenience())
                .petrol(requestDto.getPetrol())
                .splAllowance(requestDto.getSplAllowance())
                .build();
        return salary;
    }
}
