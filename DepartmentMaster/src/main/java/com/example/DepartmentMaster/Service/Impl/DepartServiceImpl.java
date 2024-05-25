package com.example.DepartmentMaster.Service.Impl;

import com.example.DepartmentMaster.Dtos.RequestDto;
import com.example.DepartmentMaster.Models.Department;
import com.example.DepartmentMaster.Models.Employee;
import com.example.DepartmentMaster.Models.Salary;
import com.example.DepartmentMaster.Repository.DepartRepository;

import com.example.DepartmentMaster.Service.DepartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartServiceImpl implements DepartService {

   @Autowired
   private DepartRepository departRepository;


   @Autowired
   private RestTemplate restTemplate;



   private Logger logger = LoggerFactory.getLogger(DepartServiceImpl.class);

    @Override
    public String createDepartment(RequestDto requestDto) {
        Department department = new Department();
        department.setDepartName(requestDto.getDepartName());

        departRepository.save(department);
        return "Department created successfully";
    }

    @Override
    public Department getDepartmentById(Integer departId) {
        Optional<Department> departmentOptional = departRepository.findById(departId);

        if(departmentOptional.isEmpty()){
            return null;
        }

        Department department = departmentOptional.get();

        try {
            ResponseEntity<List<Employee>> response = restTemplate.exchange(
                    "http://EMPLOYEE-MASTER/employee/getAll",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Employee>>() {}
            );
            List<Employee> employees = response.getBody();
            logger.info("Response body: {}", response.getBody());

//            List<Employee> employeeList = employees.stream().map(employee -> {
//                String empcode = employee.getEmpCode();
//                Salary salary = restTemplate.getForObject("http://SALARY-SERVICE/salary/get/"+empcode, Salary.class);
//                employee.setSalary(salary);
//                return employee;
//            }).collect(Collectors.toList());

            department.setEmployeeList(employees);
        } catch (RestClientException ex) {
            logger.error("Error calling the REST API: {}", ex.getMessage());
        }

        return department;
    }

    @Override
    public List<Department> getAllDepartments() {
        return departRepository.findAll();
    }

    @Override
    public String updateDepartment(Integer departId, Department updatedDepartment) {
        Optional<Department> departmentOptional = departRepository.findById(departId);
        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();
            department.setDepartName(updatedDepartment.getDepartName());

            departRepository.save(department);
            return "Department updated successfully";
        }
        return "Department not found";
    }

    @Override
    public String deleteDepartment(Integer departId) {
        Optional<Department> departmentOptional = departRepository.findById(departId);
        if (departmentOptional.isPresent()) {
            departRepository.deleteById(departId);
            return "Department deleted successfully";
        }
        return "Department not found";
    }

    @Override
    public Double calculateService(String empCode, String monthName)throws Exception {

        Employee employee = restTemplate.getForObject("http://EMPLOYEE-MASTER/employee/get/"+empCode,Employee.class);
        if(employee==null){
            throw new RuntimeException("not found");
        }

        logger.info("here is employee --->>>>"+employee.getEmpAadhaarCardNo());

        Salary salary = employee.getSalary();
        return 0.0;
    }
}
