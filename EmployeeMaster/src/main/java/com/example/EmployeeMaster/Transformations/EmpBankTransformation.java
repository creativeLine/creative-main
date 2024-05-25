package com.example.EmployeeMaster.Transformations;

import com.example.EmployeeMaster.Dtos.RequestDto.EmpBankReDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpBankResponseDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpResponseDto;
import com.example.EmployeeMaster.Models.Employee;
import com.example.EmployeeMaster.Models.EmployeeBank;

public class EmpBankTransformation {

    public static EmployeeBank convertEntity(EmpBankReDto empBankReDto){
        EmployeeBank employeeBank = EmployeeBank.builder()
                .bankName(empBankReDto.getBankName())
                .accountNo(empBankReDto.getAccountNo())
                .branch(empBankReDto.getBranch())
                .ifscCode(empBankReDto.getIfscCode())
                .build();
        return  employeeBank;
    }

    public static EmpBankResponseDto convertIntoResponse(EmployeeBank employeeBank) {

        EmpBankResponseDto responseDto = EmpBankResponseDto.builder()
                .accountNo(employeeBank.getAccountNo())
                .bankName(employeeBank.getBankName())
                .branch(employeeBank.getBranch())
                .ifscCode(employeeBank.getIfscCode())
                .build();
        return responseDto;
    }
}
