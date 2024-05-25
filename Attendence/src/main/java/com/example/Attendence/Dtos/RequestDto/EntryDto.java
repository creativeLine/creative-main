package com.example.Attendence.Dtos.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntryDto {


    private Time timeIn;
    private String empCode;
    private Integer dayId;
    private String monthName;

}
