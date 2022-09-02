package com.example.springemployeepayroll.service;

import com.example.springemployeepayroll.dto.EmpDto;
import com.example.springemployeepayroll.model.EmployeeEntity;
import com.example.springemployeepayroll.repo.Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    Repo repository;
    public String welcomeMessage(){
        return "This is Employee Payroll App";
    }

    @Override
    public EmployeeEntity saveData(EmpDto empData) {
        EmployeeEntity newEmpData = new EmployeeEntity(empData);
        return repository.save(newEmpData);
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return repository.findById(id);
    }
    @Override
    public List<EmployeeEntity> findAllData() {
        return repository.findAll();
    }

    @Override
    public EmployeeEntity editData(EmpDto empData, Long id) {
        EmployeeEntity existingData = repository.findById(id).orElse(null);
        if (existingData != null) {
            existingData.setEmployeeName(empData.getEmployeeName());
            existingData.setProfilePic(empData.getProfilePic());
            existingData.setGender(empData.getGender());
            existingData.setSalary(empData.getSalary());
            existingData.setDepartment(empData.getDepartment());
            existingData.setStartDate(empData.getStartDate());
            existingData.setNotes(empData.getNotes());
            return repository.save(existingData);
        }
        else
            return null;
    }
    @Override
    public void deleteData(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<EmployeeEntity> getEmployeesByDepartment(String department) {
        return repository.findEmployeesByDepartment(department);
    }
}