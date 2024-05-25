package com.example.Attendence.Dtos.RequestDto;


import com.example.Attendence.Enum.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DayDto {

    private Integer monthId;
    private String monthName;
    private String empCode;
    private Date date;


}
