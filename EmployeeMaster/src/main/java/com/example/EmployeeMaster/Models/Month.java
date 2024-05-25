package com.example.EmployeeMaster.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
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
    List<Day> dayList;




}
