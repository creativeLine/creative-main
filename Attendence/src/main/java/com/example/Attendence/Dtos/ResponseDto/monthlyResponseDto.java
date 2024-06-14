package com.example.Attendence.Dtos.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class monthlyResponseDto {
    private double totalWorkingHoursInMonth;

    private Integer totalPresentDayInMonth;
    private Integer totalAbsentDayInMonth;
    private Integer totalHalfDayInMonth;
    private String  monthName;

    private List<perDayResponseDto> list = new ArrayList<>();

}
