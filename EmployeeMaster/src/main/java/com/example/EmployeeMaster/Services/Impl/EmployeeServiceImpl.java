package com.example.EmployeeMaster.Services.Impl;
import com.example.EmployeeMaster.Dtos.RequestDto.EmpRequestDto;
import com.example.EmployeeMaster.Exceptions.EmpCodeAlreadyPresent;
import com.example.EmployeeMaster.Exceptions.employeeNotFound;
import com.example.EmployeeMaster.Models.Attendance;
import com.example.EmployeeMaster.Models.Employee;
import com.example.EmployeeMaster.Models.Salary;
import com.example.EmployeeMaster.Repository.EmployeeRepository;
import com.example.EmployeeMaster.Services.EmployeeService;
import com.example.EmployeeMaster.Transformations.EmpTransformation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RestTemplate restTemplate;

    // Logger for logging messages
    private final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    // Save employee details
    @Override
    public String save(EmpRequestDto empRequestDto) throws Exception {
        // Convert DTO to Entity
        Employee employee = EmpTransformation.convertEntity(empRequestDto);

        // Check if employee code already exists
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(employee.getEmpCode());
        if (optionalEmployee.isPresent()) {
            throw new EmpCodeAlreadyPresent("This employee code already exists");
        }

        // Set salary to null (assuming salary is managed separately)
        employee.setSalary(null);

        // Save the employee
        employeeRepository.save(employee);

        return "Employee has been saved";
    }

    // Get all employees with their salaries
    @Override
    public List<Employee> getAll() {
        // Retrieve all employees
        List<Employee> employees = employeeRepository.findAll();

        // Iterate through each employee
        for (Employee employee : employees) {
            // Retrieve salary information for each employee from salary service
            Salary salary = restTemplate.getForObject("http://SALARY-SERVICE/salary/get/" + employee.getEmpCode(), Salary.class);
            // Set the retrieved salary to the employee


            Attendance attendance = restTemplate.getForObject("http://ATTENDANCE/attendance/get/"+employee.getEmpCode(),Attendance.class);
            employee.setAttendance(attendance);
            employee.setSalary(salary);
        }

        return employees;
    }

    // Get an employee by transaction ID with associated salary
    @Override
    public Employee getEmployee(String empCode) {
        // Find employee by transaction ID
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(empCode);
        if (optionalEmployee.isEmpty()) {
            return null;
        }
        Employee employee = optionalEmployee.get();
        // Get employee code
//        String empCode = employee.getEmpCode();
        // Retrieve salary information for the employee from salary service
        Salary salary = restTemplate.getForObject("http://SALARY-SERVICE/salary/get/" + empCode, Salary.class);


        Attendance attendance = restTemplate.getForObject("http://ATTENDANCE/attendance/get/"+empCode,Attendance.class);

        // Set the retrieved salary to the employee
        employee.setSalary(salary);

        employee.setAttendance(attendance);
        // Log salary information
        logger.info("Salary: {}", salary);
        logger.info("Salary: {}", attendance);

        return employee;
    }

    // Update employee details
    @Override
    public String update(EmpRequestDto empRequestDto) throws Exception {
        // Find employee by employee code
        Optional<Employee> optionalEmployee = employeeRepository.findByEmpCode(empRequestDto.getEmpCode());
        // Check if employee exists
        if (optionalEmployee.isEmpty()) {
            throw new employeeNotFound("Employee with empCode " + empRequestDto.getEmpCode() + " does not exist");
        }
        // Perform update operation
        // TODO: Implement update logic
        return ""; // Placeholder for update success message
    }

    // Get total number of employees
    @Override
    public int getTotal() {
        // Retrieve all employees and count them
        List<Employee> list = employeeRepository.findAll();
        return list.size();

    }


}
