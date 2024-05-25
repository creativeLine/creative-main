package com.example.Attendence.Service;

import com.example.Attendence.Dtos.RequestDto.EntryDto;
import com.example.Attendence.Dtos.RequestDto.ExitDto;

public interface EntriesService {


    void saveIn(EntryDto request)throws Exception;

    String saveOut(ExitDto request)throws Exception;
}
