package com.example.EmployeeMaster.Services;


import com.example.EmployeeMaster.Dtos.RequestDto.EmpRequestDto;
import com.example.EmployeeMaster.Models.Employee;

import java.util.List;

public interface EmployeeService {
    String save(EmpRequestDto empRequestDto)throws Exception;

    List<Employee> getAll();

    Employee getEmployee(String empCode);

    String update(EmpRequestDto empRequestDto) throws Exception;

    int getTotal();

    String delete(String empCode)throws Exception;

    List<String> nameList();
}

