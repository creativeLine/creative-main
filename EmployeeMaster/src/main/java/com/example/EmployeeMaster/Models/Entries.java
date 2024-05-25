package com.example.EmployeeMaster.Models;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
