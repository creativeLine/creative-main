package com.example.EmployeeMaster.Dtos.ResponseDto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmpBankResponseDto {

    private String bankName;
    private String branch;
    private String accountNo;
    private String ifscCode;
}

