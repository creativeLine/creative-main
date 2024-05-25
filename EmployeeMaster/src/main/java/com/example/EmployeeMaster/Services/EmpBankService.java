package com.example.EmployeeMaster.Services;

import com.example.EmployeeMaster.Dtos.RequestDto.EmpBankReDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpBankResponseDto;

public interface EmpBankService {
    String save(EmpBankReDto empBankReDto)throws Exception;

    EmpBankResponseDto get(String empCode)throws Exception;

    String delete(String empCode)throws Exception;
}
