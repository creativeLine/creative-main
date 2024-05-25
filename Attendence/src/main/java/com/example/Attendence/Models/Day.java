package com.example.Attendence.Models;


import com.example.Attendence.Enum.Status;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dayId;

    private String empCode;
    private Date date;
    private String totalWorkingHourInDay;
    private Status status;


    @JoinColumn
    @ManyToOne
    @JsonIgnore
    private Month month;


    @OneToMany(mappedBy = "day",cascade = CascadeType.ALL)
    private List<Entries> entries;




}
