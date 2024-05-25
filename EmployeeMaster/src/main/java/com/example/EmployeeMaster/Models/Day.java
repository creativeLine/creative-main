package com.example.EmployeeMaster.Models;

import com.example.EmployeeMaster.Enum.Status;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jdk.jshell.Snippet;
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
