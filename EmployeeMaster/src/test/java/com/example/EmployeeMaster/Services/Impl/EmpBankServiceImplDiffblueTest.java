package com.example.EmployeeMaster.Services.Impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.EmployeeMaster.Dtos.RequestDto.EmpBankReDto;
import com.example.EmployeeMaster.Dtos.ResponseDto.EmpBankResponseDto;
import com.example.EmployeeMaster.Models.Employee;
import com.example.EmployeeMaster.Models.EmployeeBank;
import com.example.EmployeeMaster.Models.Salary;
import com.example.EmployeeMaster.Repository.EmpBankRepository;
import com.example.EmployeeMaster.Repository.EmployeeRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {EmpBankServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DisabledInAotMode
class EmpBankServiceImplDiffblueTest {
    @MockBean
    private EmpBankRepository empBankRepository;

    @Autowired
    private EmpBankServiceImpl empBankServiceImpl;

    @MockBean
    private EmployeeRepository employeeRepository;

    /**
     * Method under test: {@link EmpBankServiceImpl#save(EmpBankReDto)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSave() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        EmpBankReDto empBankReDto = null;

        // Act
        String actualSaveResult = this.empBankServiceImpl.save(empBankReDto);

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link EmpBankServiceImpl#get(String)}
     */
    @Test
    void testGet() throws Exception {
        // Arrange
        EmployeeBank employeeBank = new EmployeeBank();
        employeeBank.setAccountNo("3");
        employeeBank.setBankName("Bank Name");
        employeeBank.setBranch("janedoe/featurebranch");
        employeeBank.setEmployee(new Employee());
        employeeBank.setId(1);
        employeeBank.setIfscCode("Ifsc Code");

        Employee employee = new Employee();
        employee.setDailyWageHours(mock(Time.class));
        employee.setEmpAadhaarCardNo("Emp Aadhaar Card No");
        employee.setEmpAge("Emp Age");
        employee.setEmpBasicPay(10.0d);
        employee.setEmpCatgCode("Emp Catg Code");
        employee.setEmpCode("Emp Code");
        employee.setEmpDOB(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDOJ(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDOL(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDeptCode("Emp Dept Code");
        employee.setEmpDesgCode("Emp Desg Code");
        employee.setEmpESIDTag(true);
        employee.setEmpEfpfTag(true);
        employee.setEmpEmail("jane.doe@example.org");
        employee.setEmpEpfTag(true);
        employee.setEmpGuardianName("Emp Guardian Name");
        employee.setEmpGuardianRelations("Emp Guardian Relations");
        employee.setEmpHealthIns("Emp Health Ins");
        employee.setEmpImage("Emp Image");
        employee.setEmpLeftTag("Emp Left Tag");
        employee.setEmpLunchTag(true);
        employee.setEmpLunchTime(mock(Time.class));
        employee.setEmpMaritalStatus("Emp Marital Status");
        employee.setEmpMiscDed(10.0d);
        employee.setEmpMotherName("Emp Mother Name");
        employee.setEmpName("Emp Name");
        employee.setEmpNationality("Emp Nationality");
        employee.setEmpNominee("Emp Nominee");
        employee.setEmpNomineeDOB("Emp Nominee DOB");
        employee.setEmpNomineeRelations("Emp Nominee Relations");
        employee.setEmpOverTimeTag(true);
        employee.setEmpPanNo("Emp Pan No");
        employee.setEmpPaymentMode("Emp Payment Mode");
        employee.setEmpPerHourWageTag(true);
        employee.setEmpRelaxTime(mock(Time.class));
        employee.setEmpReligion("Emp Religion");
        employee.setEmpRemarks("Emp Remarks");
        employee.setEmpSundayTag(true);
        employee.setEmpTds(10.0d);
        employee.setEmpTeaTag(true);
        employee.setEmpTeaTag2(true);
        employee.setEmpTeaTime(mock(Time.class));
        employee.setEmpTeaTime2(mock(Time.class));
        employee.setEmpTimeDedOnlyTag(true);
        employee.setEmpTimeInFirst(mock(Time.class));
        employee.setEmpTimeInLast(mock(Time.class));
        employee.setEmpTimeOutFirst(mock(Time.class));
        employee.setEmpTimeOutLast(mock(Time.class));
        employee.setEmpUnitCode("Emp Unit Code");
        employee.setEmpWorkingHours(mock(Time.class));
        employee.setEmployeeBank(employeeBank);
        employee.setGender("Gender");
        employee.setLunchBreakIn(mock(Time.class));
        employee.setLunchBreakOut(mock(Time.class));
        employee.setPerHourWage(10.0d);
        employee.setPerHourWageTime(mock(Time.class));
        employee.setSalary(new Salary());
        employee.setTeaBreak1In(mock(Time.class));
        employee.setTeaBreak1Out(mock(Time.class));
        employee.setTeaBreak2In(mock(Time.class));
        employee.setTeaBreak2Out(mock(Time.class));
        employee.setTransId(1L);

        EmployeeBank employeeBank2 = new EmployeeBank();
        employeeBank2.setAccountNo("3");
        employeeBank2.setBankName("Bank Name");
        employeeBank2.setBranch("janedoe/featurebranch");
        employeeBank2.setEmployee(employee);
        employeeBank2.setId(1);
        employeeBank2.setIfscCode("Ifsc Code");

        Employee employee2 = new Employee();
        employee2.setDailyWageHours(mock(Time.class));
        employee2.setEmpAadhaarCardNo("Emp Aadhaar Card No");
        employee2.setEmpAge("Emp Age");
        employee2.setEmpBasicPay(10.0d);
        employee2.setEmpCatgCode("Emp Catg Code");
        employee2.setEmpCode("Emp Code");
        employee2.setEmpDOB(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDOJ(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDOL(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDeptCode("Emp Dept Code");
        employee2.setEmpDesgCode("Emp Desg Code");
        employee2.setEmpESIDTag(true);
        employee2.setEmpEfpfTag(true);
        employee2.setEmpEmail("jane.doe@example.org");
        employee2.setEmpEpfTag(true);
        employee2.setEmpGuardianName("Emp Guardian Name");
        employee2.setEmpGuardianRelations("Emp Guardian Relations");
        employee2.setEmpHealthIns("Emp Health Ins");
        employee2.setEmpImage("Emp Image");
        employee2.setEmpLeftTag("Emp Left Tag");
        employee2.setEmpLunchTag(true);
        employee2.setEmpLunchTime(mock(Time.class));
        employee2.setEmpMaritalStatus("Emp Marital Status");
        employee2.setEmpMiscDed(10.0d);
        employee2.setEmpMotherName("Emp Mother Name");
        employee2.setEmpName("Emp Name");
        employee2.setEmpNationality("Emp Nationality");
        employee2.setEmpNominee("Emp Nominee");
        employee2.setEmpNomineeDOB("Emp Nominee DOB");
        employee2.setEmpNomineeRelations("Emp Nominee Relations");
        employee2.setEmpOverTimeTag(true);
        employee2.setEmpPanNo("Emp Pan No");
        employee2.setEmpPaymentMode("Emp Payment Mode");
        employee2.setEmpPerHourWageTag(true);
        employee2.setEmpRelaxTime(mock(Time.class));
        employee2.setEmpReligion("Emp Religion");
        employee2.setEmpRemarks("Emp Remarks");
        employee2.setEmpSundayTag(true);
        employee2.setEmpTds(10.0d);
        employee2.setEmpTeaTag(true);
        employee2.setEmpTeaTag2(true);
        employee2.setEmpTeaTime(mock(Time.class));
        employee2.setEmpTeaTime2(mock(Time.class));
        employee2.setEmpTimeDedOnlyTag(true);
        employee2.setEmpTimeInFirst(mock(Time.class));
        employee2.setEmpTimeInLast(mock(Time.class));
        employee2.setEmpTimeOutFirst(mock(Time.class));
        employee2.setEmpTimeOutLast(mock(Time.class));
        employee2.setEmpUnitCode("Emp Unit Code");
        employee2.setEmpWorkingHours(mock(Time.class));
        employee2.setEmployeeBank(employeeBank2);
        employee2.setGender("Gender");
        employee2.setLunchBreakIn(mock(Time.class));
        employee2.setLunchBreakOut(mock(Time.class));
        employee2.setPerHourWage(10.0d);
        employee2.setPerHourWageTime(mock(Time.class));
        employee2.setSalary(new Salary());
        employee2.setTeaBreak1In(mock(Time.class));
        employee2.setTeaBreak1Out(mock(Time.class));
        employee2.setTeaBreak2In(mock(Time.class));
        employee2.setTeaBreak2Out(mock(Time.class));
        employee2.setTransId(1L);
        Optional<Employee> ofResult = Optional.of(employee2);
        when(employeeRepository.findByEmpCode(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        EmpBankResponseDto actualGetResult = empBankServiceImpl.get("Emp Code");

        // Assert
        verify(employeeRepository).findByEmpCode(eq("Emp Code"));
        assertEquals("3", actualGetResult.getAccountNo());
        assertEquals("Bank Name", actualGetResult.getBankName());
        assertEquals("Ifsc Code", actualGetResult.getIfscCode());
        assertEquals("janedoe/featurebranch", actualGetResult.getBranch());
    }

    /**
     * Method under test: {@link EmpBankServiceImpl#delete(String)}
     */
    @Test
    void testDelete() throws Exception {
        // Arrange
        doNothing().when(empBankRepository).delete(Mockito.<EmployeeBank>any());

        EmployeeBank employeeBank = new EmployeeBank();
        employeeBank.setAccountNo("3");
        employeeBank.setBankName("Bank Name");
        employeeBank.setBranch("janedoe/featurebranch");
        employeeBank.setEmployee(new Employee());
        employeeBank.setId(1);
        employeeBank.setIfscCode("Ifsc Code");

        Employee employee = new Employee();
        employee.setDailyWageHours(mock(Time.class));
        employee.setEmpAadhaarCardNo("Emp Aadhaar Card No");
        employee.setEmpAge("Emp Age");
        employee.setEmpBasicPay(10.0d);
        employee.setEmpCatgCode("Emp Catg Code");
        employee.setEmpCode("Emp Code");
        employee.setEmpDOB(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDOJ(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDOL(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee.setEmpDeptCode("Emp Dept Code");
        employee.setEmpDesgCode("Emp Desg Code");
        employee.setEmpESIDTag(true);
        employee.setEmpEfpfTag(true);
        employee.setEmpEmail("jane.doe@example.org");
        employee.setEmpEpfTag(true);
        employee.setEmpGuardianName("Emp Guardian Name");
        employee.setEmpGuardianRelations("Emp Guardian Relations");
        employee.setEmpHealthIns("Emp Health Ins");
        employee.setEmpImage("Emp Image");
        employee.setEmpLeftTag("Emp Left Tag");
        employee.setEmpLunchTag(true);
        employee.setEmpLunchTime(mock(Time.class));
        employee.setEmpMaritalStatus("Emp Marital Status");
        employee.setEmpMiscDed(10.0d);
        employee.setEmpMotherName("Emp Mother Name");
        employee.setEmpName("Emp Name");
        employee.setEmpNationality("Emp Nationality");
        employee.setEmpNominee("Emp Nominee");
        employee.setEmpNomineeDOB("Emp Nominee DOB");
        employee.setEmpNomineeRelations("Emp Nominee Relations");
        employee.setEmpOverTimeTag(true);
        employee.setEmpPanNo("Emp Pan No");
        employee.setEmpPaymentMode("Emp Payment Mode");
        employee.setEmpPerHourWageTag(true);
        employee.setEmpRelaxTime(mock(Time.class));
        employee.setEmpReligion("Emp Religion");
        employee.setEmpRemarks("Emp Remarks");
        employee.setEmpSundayTag(true);
        employee.setEmpTds(10.0d);
        employee.setEmpTeaTag(true);
        employee.setEmpTeaTag2(true);
        employee.setEmpTeaTime(mock(Time.class));
        employee.setEmpTeaTime2(mock(Time.class));
        employee.setEmpTimeDedOnlyTag(true);
        employee.setEmpTimeInFirst(mock(Time.class));
        employee.setEmpTimeInLast(mock(Time.class));
        employee.setEmpTimeOutFirst(mock(Time.class));
        employee.setEmpTimeOutLast(mock(Time.class));
        employee.setEmpUnitCode("Emp Unit Code");
        employee.setEmpWorkingHours(mock(Time.class));
        employee.setEmployeeBank(employeeBank);
        employee.setGender("Gender");
        employee.setLunchBreakIn(mock(Time.class));
        employee.setLunchBreakOut(mock(Time.class));
        employee.setPerHourWage(10.0d);
        employee.setPerHourWageTime(mock(Time.class));
        employee.setSalary(new Salary());
        employee.setTeaBreak1In(mock(Time.class));
        employee.setTeaBreak1Out(mock(Time.class));
        employee.setTeaBreak2In(mock(Time.class));
        employee.setTeaBreak2Out(mock(Time.class));
        employee.setTransId(1L);

        EmployeeBank employeeBank2 = new EmployeeBank();
        employeeBank2.setAccountNo("3");
        employeeBank2.setBankName("Bank Name");
        employeeBank2.setBranch("janedoe/featurebranch");
        employeeBank2.setEmployee(employee);
        employeeBank2.setId(1);
        employeeBank2.setIfscCode("Ifsc Code");

        Employee employee2 = new Employee();
        employee2.setDailyWageHours(mock(Time.class));
        employee2.setEmpAadhaarCardNo("Emp Aadhaar Card No");
        employee2.setEmpAge("Emp Age");
        employee2.setEmpBasicPay(10.0d);
        employee2.setEmpCatgCode("Emp Catg Code");
        employee2.setEmpCode("Emp Code");
        employee2.setEmpDOB(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDOJ(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDOL(Date.from(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant()));
        employee2.setEmpDeptCode("Emp Dept Code");
        employee2.setEmpDesgCode("Emp Desg Code");
        employee2.setEmpESIDTag(true);
        employee2.setEmpEfpfTag(true);
        employee2.setEmpEmail("jane.doe@example.org");
        employee2.setEmpEpfTag(true);
        employee2.setEmpGuardianName("Emp Guardian Name");
        employee2.setEmpGuardianRelations("Emp Guardian Relations");
        employee2.setEmpHealthIns("Emp Health Ins");
        employee2.setEmpImage("Emp Image");
        employee2.setEmpLeftTag("Emp Left Tag");
        employee2.setEmpLunchTag(true);
        employee2.setEmpLunchTime(mock(Time.class));
        employee2.setEmpMaritalStatus("Emp Marital Status");
        employee2.setEmpMiscDed(10.0d);
        employee2.setEmpMotherName("Emp Mother Name");
        employee2.setEmpName("Emp Name");
        employee2.setEmpNationality("Emp Nationality");
        employee2.setEmpNominee("Emp Nominee");
        employee2.setEmpNomineeDOB("Emp Nominee DOB");
        employee2.setEmpNomineeRelations("Emp Nominee Relations");
        employee2.setEmpOverTimeTag(true);
        employee2.setEmpPanNo("Emp Pan No");
        employee2.setEmpPaymentMode("Emp Payment Mode");
        employee2.setEmpPerHourWageTag(true);
        employee2.setEmpRelaxTime(mock(Time.class));
        employee2.setEmpReligion("Emp Religion");
        employee2.setEmpRemarks("Emp Remarks");
        employee2.setEmpSundayTag(true);
        employee2.setEmpTds(10.0d);
        employee2.setEmpTeaTag(true);
        employee2.setEmpTeaTag2(true);
        employee2.setEmpTeaTime(mock(Time.class));
        employee2.setEmpTeaTime2(mock(Time.class));
        employee2.setEmpTimeDedOnlyTag(true);
        employee2.setEmpTimeInFirst(mock(Time.class));
        employee2.setEmpTimeInLast(mock(Time.class));
        employee2.setEmpTimeOutFirst(mock(Time.class));
        employee2.setEmpTimeOutLast(mock(Time.class));
        employee2.setEmpUnitCode("Emp Unit Code");
        employee2.setEmpWorkingHours(mock(Time.class));
        employee2.setEmployeeBank(employeeBank2);
        employee2.setGender("Gender");
        employee2.setLunchBreakIn(mock(Time.class));
        employee2.setLunchBreakOut(mock(Time.class));
        employee2.setPerHourWage(10.0d);
        employee2.setPerHourWageTime(mock(Time.class));
        employee2.setSalary(new Salary());
        employee2.setTeaBreak1In(mock(Time.class));
        employee2.setTeaBreak1Out(mock(Time.class));
        employee2.setTeaBreak2In(mock(Time.class));
        employee2.setTeaBreak2Out(mock(Time.class));
        employee2.setTransId(1L);
        Optional<Employee> ofResult = Optional.of(employee2);
        when(employeeRepository.findByEmpCode(Mockito.<String>any())).thenReturn(ofResult);

        // Act
        String actualDeleteResult = empBankServiceImpl.delete("Emp Code");

        // Assert
        verify(employeeRepository).findByEmpCode(eq("Emp Code"));
        verify(empBankRepository).delete(isA(EmployeeBank.class));
        assertEquals("successfully deleted", actualDeleteResult);
    }
}
