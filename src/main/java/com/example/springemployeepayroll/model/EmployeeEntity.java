package com.example.springemployeepayroll.model;

import com.fasterxml.jackson.databind.DatabindException;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class EmployeeEntity {
    @Id
    Long employeeId;
    String employeeName;
    String profilePic;
    String gender;
    Long salary;
    String department;
    Date startDate;
    String notes;

    public EmployeeEntity(Long employeeId, String employeeName, String profilePic, String gender, Long salary, String department, Date startDate, String notes) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.profilePic = profilePic;
        this.gender = gender;
        this.salary = salary;
        this.department = department;
        this.startDate = startDate;
        this.notes = notes;
    }

    public EmployeeEntity() {

    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
