package com.example.EmployeeMaster.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private String bankName;
    private String branch;
    private String accountNo;
    private String ifscCode;


    @OneToOne
    @JoinColumn
    @JsonIgnore
    private Employee employee;

}
