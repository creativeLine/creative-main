package com.example.EmployeeMaster.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {




    private Double basicPay;
    private Double hra;
    private Double convenience;
    private Double petrol;
    private Double splAllowance;
}
