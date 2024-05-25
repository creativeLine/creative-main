package com.example.DepartmentMaster.Models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Month {




    private String monthName;

    private Double totalWorkingHourInMonth;

//    private Double totalWorkingHourInMonth;
    private List<Day> dayList;




}
