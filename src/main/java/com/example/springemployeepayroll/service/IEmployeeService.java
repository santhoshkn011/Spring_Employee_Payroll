package com.example.springemployeepayroll.service;

import com.example.springemployeepayroll.dto.EmpDto;
import com.example.springemployeepayroll.model.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    String welcomeMessage();
    EmployeeEntity saveData(EmpDto empData);
    List<EmployeeEntity> findAllData();
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity editData(EmpDto empData, Long id);
    void deleteData(Long id);
    List<EmployeeEntity> getEmployeesByDepartment(String department);
}
