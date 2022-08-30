package com.example.springemployeepayroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmpDto {
    String employeeName;
    String profilePic;
    String gender;
    int salary;
    String department;
    LocalDate startDate;
    String notes;

    public EmpDto(String employeeName, String profilePic, String gender, int salary, String department, LocalDate startDate, String notes) {
        this.employeeName = employeeName;
        this.profilePic = profilePic;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
        this.startDate = startDate;
        this.notes = notes;
    }
}
