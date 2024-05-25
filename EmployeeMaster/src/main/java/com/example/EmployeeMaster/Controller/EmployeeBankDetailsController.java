package com.example.EmployeeMaster.Controller;


import com.example.EmployeeMaster.Dtos.RequestDto.EmpBankReDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpBankResponseDto;
import com.example.EmployeeMaster.Services.EmpBankService;
import org.hibernate.boot.model.internal.CreateKeySecondPass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankDetails")
public class EmployeeBankDetailsController {


    @Autowired
    private EmpBankService empBankService;


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody EmpBankReDto empBankReDto)throws Exception{
        try{
            String response = empBankService.save(empBankReDto);
            return new ResponseEntity(response, HttpStatus.CREATED);

        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }


    @GetMapping("/getBank/{empCode}")
    public ResponseEntity getBank(@PathVariable String empCode) throws Exception{
        try{
            EmpBankResponseDto response = empBankService.get(empCode);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


    @DeleteMapping("/delete/{empCode}")
    public ResponseEntity delete(@PathVariable String empCode) throws Exception{
        try{
            String response = empBankService.delete(empCode);
            return new ResponseEntity(response,HttpStatus.ACCEPTED);
        }catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.CONFLICT);
        }
    }

}
