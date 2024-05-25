package com.example.EmployeeMaster.Dtos.RequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmpBankReDto {

    private String  empCode;
    private String bankName;
    private String branch;
    private String accountNo;
    private String ifscCode;
}
