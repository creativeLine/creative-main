package com.example.Attendence.Dtos.RequestDto;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExitDto {

    private Integer dayId;
    private Time timeOut;
    private String empCode;
    private Integer entriesId;
}
