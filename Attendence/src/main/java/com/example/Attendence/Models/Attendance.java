package com.example.Attendence.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "monthList") // Exclude this field from toString to avoid recursion
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attendId;

    private String empCode;

    @OneToMany(mappedBy = "attendance", cascade = CascadeType.ALL)
    private List<Month> monthList;

    // Custom toString method if needed
    @Override
    public String toString() {
        return "Attendance{id=" + attendId + ", empCode='" + empCode + "'}";
    }
}
