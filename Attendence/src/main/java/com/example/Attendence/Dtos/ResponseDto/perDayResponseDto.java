package com.example.Attendence.Dtos.ResponseDto;


import com.example.Attendence.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class perDayResponseDto {


    private Date date;
    private Status status;
    private Time entryTime;
    private Time exitTime;

    private Double totalTime;


}
