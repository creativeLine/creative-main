package com.example.EmployeeMaster.Repository;

import com.example.EmployeeMaster.Models.EmployeeBank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpBankRepository extends JpaRepository<EmployeeBank,Integer> {

}
