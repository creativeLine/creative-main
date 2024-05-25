package com.example.DepartmentMaster.Models;

import com.example.DepartmentMaster.Enum.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Day {

     private Status status;
     private String  totalWorkingHourInDay;
//
    private List<Entries> entries;
}
