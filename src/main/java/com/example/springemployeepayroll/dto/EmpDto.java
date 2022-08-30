package com.example.springemployeepayroll.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class EmpDto {
    String employeeName;
    String profilePic;
    String gender;
    Long salary;
    String department;
    Date startDate;
    String notes;
}
