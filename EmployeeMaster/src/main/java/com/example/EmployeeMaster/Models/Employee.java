package com.example.EmployeeMaster.Models;

import com.example.EmployeeMaster.Enum.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public  class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transId;

    private String empCode;
    private String empName;
    private String empCatgCode;
    private String empDeptCode;
    private String empDesgCode;
    private String empUnitCode;
    private Date empDOJ;
    private Date empDOL;
    private String empLeftTag;
    private String empAge;
    private String empImage;
    private Date empDOB;
    //    @Enumerated(value = EnumType.STRING)
    private String gender;
    private String empGuardianName;
    private String empGuardianRelations;
    private String empMotherName;
    private String empNationality;
    private String empEmail;
    private String empRemarks;
    private String empHealthIns;
    private Double empTds;
    private Double empMiscDed;
    private String EmpReligion;
    private String empPaymentMode;
    private String empAadhaarCardNo;
    private String empPanNo;
    private String empMaritalStatus;
    private String empNominee;
    private String empNomineeRelations;
    private String empNomineeDOB;

    private Time empTimeInFirst;
    private Time empTimeOutFirst;
    private Time empTimeInLast;
    private Time empTimeOutLast;
    private Time empWorkingHours;
    private Double empBasicPay;
    private Time empRelaxTime;
    private Time empTeaTime;
    private Time empLunchTime;
    private Time empTeaTime2;
    private Time teaBreak1Out;
    private Time teaBreak2Out;
    private Time teaBreak1In;
    private Time teaBreak2In;
    private Time LunchBreakIn;
    private Time LunchBreakOut;
    private Double perHourWage;
    private Time perHourWageTime;
    private Time dailyWageHours;

    private Boolean empTeaTag;
    private Boolean empLunchTag;
    private Boolean empOverTimeTag;
    private Boolean empSundayTag;
    private Boolean empTimeDedOnlyTag;
    private Boolean empTeaTag2;
    private Boolean empPerHourWageTag;
    private Boolean empEpfTag;
    private Boolean empEfpfTag;
    private Boolean empESIDTag;


    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    private EmployeeBank employeeBank;


    @Transient
    private Salary salary;

    @Transient
    private Attendance attendance;
}