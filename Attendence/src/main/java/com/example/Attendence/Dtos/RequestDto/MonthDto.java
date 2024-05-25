package com.example.Attendence.Dtos.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MonthDto {
    private String empCode;

    private String monthName;
}
