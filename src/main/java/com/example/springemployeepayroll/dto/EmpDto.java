package com.example.springemployeepayroll.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EmpDto {
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message="Invalid Name(Should have 1 Upper Case and min 3 Characters.)")
    String employeeName;
    String profilePic;
    @NotEmpty(message = "Gender Cannot be Empty")
    String gender;
    @Min(value = 5000, message="Salary Should be More than 5000")
    int salary;
    @NotEmpty(message = "Department cannot be Empty")
    String department;

    //Add  jackson-databind  dependency
    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "Start Date cannot be Empty")
    @PastOrPresent(message = "Start Date should be past or present date")
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
