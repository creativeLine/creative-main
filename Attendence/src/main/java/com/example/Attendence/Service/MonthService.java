package com.example.Attendence.Service;

import com.example.Attendence.Dtos.RequestDto.MonthDto;

public interface MonthService {

    void save(MonthDto request)throws Exception;
}
