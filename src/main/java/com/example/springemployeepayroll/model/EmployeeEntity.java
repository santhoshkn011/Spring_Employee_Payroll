package com.example.springemployeepayroll.model;

import com.example.springemployeepayroll.dto.EmpDto;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class EmployeeEntity {
    @Id
    @GeneratedValue
    Long employeeId;
    String employeeName;
    String profilePic;
    String gender;
    int salary;
    String department;
    LocalDate startDate;
    String notes;

    public EmployeeEntity(EmpDto empData) {
        this.employeeName = empData.getEmployeeName();
        this.profilePic = empData.getProfilePic();
        this.gender = empData.getGender();
        this.salary = empData.getSalary();
        this.department = empData.getDepartment();
        this.startDate = empData.getStartDate();
        this.notes = empData.getNotes();
    }
}