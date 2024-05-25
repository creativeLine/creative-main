package com.example.DepartmentMaster.Service;

import com.example.DepartmentMaster.Dtos.RequestDto;
import com.example.DepartmentMaster.Models.Department;

import java.util.List;

public interface DepartService {
    String createDepartment(RequestDto department);

    Department getDepartmentById(Integer departId);

    List<Department> getAllDepartments();

    String updateDepartment(Integer departId, Department department);

    String  deleteDepartment(Integer departId);

    Double calculateService(String empCode, String monthName)throws Exception;
}
