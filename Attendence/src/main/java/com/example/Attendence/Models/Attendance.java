package com.example.Attendence.Models;


import com.example.Attendence.Enum.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Attendance {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendId;

    private String empCode;



    @OneToMany(mappedBy = "attendance",cascade = CascadeType.ALL)
    private List<Month> monthList;












}
