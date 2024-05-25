package com.example.Attendence.Service;

import com.example.Attendence.Dtos.RequestDto.DayDto;

import java.util.Date;

public interface DayService {
    void save(DayDto request)throws Exception;
}
