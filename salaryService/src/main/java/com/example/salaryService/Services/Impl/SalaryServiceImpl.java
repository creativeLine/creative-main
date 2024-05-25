package com.example.salaryService.Services.Impl;

import com.example.salaryService.Dtos.RequestDto.SalaryRequestDto;
import com.example.salaryService.Exceptions.invalidEmpCode;
import com.example.salaryService.Models.Salary;
import com.example.salaryService.Repository.SalaryRepository;
import com.example.salaryService.Services.SalaryService;
import com.example.salaryService.Transformations.SalaryTransformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class SalaryServiceImpl implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;


    @Override
    public String save(SalaryRequestDto salaryRequestDto) {
        Salary salary = SalaryTransformation.convertEntity(salaryRequestDto);

        salaryRepository.save(salary);

        return "saved";
    }

    @Override
    public Salary get(String empCode) throws Exception {
        Optional<Salary> optionalSalary = salaryRepository.findByEmpCode(empCode);
        if(optionalSalary.isEmpty()){
            throw new invalidEmpCode("this is invalid emp code");
        }

        return optionalSalary.get();

    }

    @Override
    public String update(SalaryRequestDto requestDto) throws Exception {
        Optional<Salary> optionalSalary = salaryRepository.findByEmpCode(requestDto.getEmpCode());
        int count =0;

        if(optionalSalary.isEmpty()){
            throw new invalidEmpCode("this is not valid");
        }

        Salary salary = optionalSalary.get();

        if(requestDto.getPetrol()!=null){
            salary.setPetrol(requestDto.getPetrol());
            count++;
        }

        if(requestDto.getConvenience()!=null){
            salary.setConvenience(requestDto.getConvenience());
            count++;

        }

        if(requestDto.getHra()!=null){
            salary.setHra(requestDto.getHra());
            count++;

        }
        if(requestDto.getBasicPay()!=null){
            salary.setBasicPay(requestDto.getBasicPay());
            count++;


        }

        if(requestDto.getSplAllowance()!=null){
            salary.setSplAllowance(requestDto.getSplAllowance());
            count++;

        }

        salaryRepository.save(salary);

        return "total "+count+" fields are updated in salary";
    }

    @Override
    public Double getTotal(String empCode) throws Exception {
        Optional<Salary> optionalSalary = salaryRepository.findByEmpCode(empCode);

        if(optionalSalary.isEmpty()){
            throw new invalidEmpCode("this emp code is not valid");

        }
        Salary salary = optionalSalary.get();

        Double total = 0.0;


        total = salary.getHra()+ salary.getConvenience()+ salary.getBasicPay()+ salary.getBasicPay()+ salary.getPetrol()+ salary.getSplAllowance();


        return total;
    }
}
