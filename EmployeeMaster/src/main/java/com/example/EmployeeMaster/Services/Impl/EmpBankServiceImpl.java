package com.example.EmployeeMaster.Services.Impl;

import com.example.EmployeeMaster.Dtos.RequestDto.EmpBankReDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpBankResponseDto;
import com.example.EmployeeMaster.Exceptions.employeeNotFound;
import com.example.EmployeeMaster.Models.Employee;
import com.example.EmployeeMaster.Models.EmployeeBank;
import com.example.EmployeeMaster.Repository.EmpBankRepository;
import com.example.EmployeeMaster.Repository.EmployeeRepository;
import com.example.EmployeeMaster.Services.EmpBankService;
import com.example.EmployeeMaster.Transformations.EmpBankTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmpBankServiceImpl implements EmpBankService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmpBankRepository empBankRepository;

    // Save employee bank details
    @Override
    public String save(EmpBankReDto empBankReDto) throws Exception {
        // Convert DTO to Entity
        EmployeeBank employeeBank = EmpBankTransformation.convertEntity(empBankReDto);

        // Find employee by employee code
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(empBankReDto.getEmpCode());

        // Check if employee exists
        if (optionalEmployee.isEmpty()) {
            throw new employeeNotFound("this is not valid empCode");
        }

        // Get the employee
        Employee employee = optionalEmployee.get();

        // Associate employee bank details with the employee
        employee.setEmployeeBank(employeeBank);
        employeeBank.setEmployee(employee);

        // Save the updated employee
        employeeRepository.save(employee);

        // Return success message
        return "bank details have been successfully saved";
    }

    // Retrieve employee bank details by employee code
    @Override
    public EmpBankResponseDto get(String empCode) throws Exception {
        // Find employee by employee code
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(empCode);

        // Check if employee exists
        if (optionalEmployee.isEmpty()) {
            throw new employeeNotFound("this is not valid empCode");
        }

        // Get the employee
        Employee employee = optionalEmployee.get();

        // Get employee bank details
        EmployeeBank employeeBank = employee.getEmployeeBank();

        // Convert entity to response DTO
        return EmpBankTransformation.convertIntoResponse(employeeBank);
    }

    // Delete employee bank details by employee code
    @Override
    public String delete(String empCode) throws Exception {
        // Find employee by employee code
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(empCode);

        // Check if employee exists
        if (optionalEmployee.isEmpty()) {
            throw new employeeNotFound("this is not valid empCode");
        }

        // Get the employee
        Employee employee = optionalEmployee.get();

        // Get employee bank details
        EmployeeBank employeeBank = employee.getEmployeeBank();

        // Delete employee bank details
        empBankRepository.delete(employeeBank);

        // Return success message
        return "bank details have been successfully deleted";
    }
}
