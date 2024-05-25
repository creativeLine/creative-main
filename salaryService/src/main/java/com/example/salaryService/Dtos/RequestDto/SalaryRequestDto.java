package com.example.salaryService.Dtos.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SalaryRequestDto {

    private String empCode;
    private Double basicPay;
    private Double hra;
    private Double convenience;
    private Double petrol;
    private Double splAllowance;
}
