package com.example.Attendence.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@ToString(exclude = {"attendance", "dayList"}) // Exclude these fields from toString to avoid recursion
public class Month {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer monthId;

    private String empCode;

    private String monthName;

    private Double totalWorkingHourInMonth;

    @ManyToOne
    @JsonIgnore
    @JoinColumn
    private Attendance attendance;

    @OneToMany(mappedBy = "month", cascade = CascadeType.ALL)
    private List<Day> dayList;

    // Custom toString method if needed
    @Override
    public String toString() {
        return "Month{id=" + monthId + ", empCode='" + empCode + "', monthName='" + monthName + "', totalWorkingHourInMonth=" + totalWorkingHourInMonth + "}";
    }
}
