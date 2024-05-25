package com.example.Attendence.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Month {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer monthId;

    private String empCode;

    private String monthName;

//    private Double totalWorkingDaysInMonth;

    private Double totalWorkingHourInMonth;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Attendance attendance;

    @OneToMany(mappedBy = "month",cascade = CascadeType.ALL)
    List<Day> dayList;

}
