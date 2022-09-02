package com.example.springemployeepayroll.model;

import com.example.springemployeepayroll.dto.EmpDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "employee_data")
public  class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Employee_ID")
    Long employeeId;
    @Column(name = "Name")
    String employeeName;
    String profilePic;
    String gender;
    int salary;
    LocalDate startDate;
    String notes;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "Department")
    List<String> department;

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