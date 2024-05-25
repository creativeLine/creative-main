package com.example.Attendence.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Entries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer entriesId;


    private String empCode;

    private Time timeIn;

    private Time timeOut;

    private Boolean entryMarked= false;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Day day;
}
