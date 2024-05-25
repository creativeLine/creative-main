package com.example.DepartmentMaster.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class Entries {
    private Time timeIn;
    private Time timeOut;
}
