package com.example.springemployeepayroll.controller;

import com.example.springemployeepayroll.model.EmployeeEntity;
import com.example.springemployeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
        @Autowired
        EmployeeService service;

        @RequestMapping(value = {"", "/", "/home"}, method = RequestMethod.GET)
        public String greet() {
            return "Hello, Welcome to Employee Payroll App";
        }
        /*
        Extending GreetingController to use Services Layer to get Simple Greeting message
         */

        @GetMapping("/service")
        public String serviceCall() {
            return service.welcomeMessage();
        }
//Insert Employee Data
        @PostMapping("/post")
        public EmployeeEntity addEmpData(@RequestBody EmployeeEntity empData) {
                service.saveData(empData);
                return empData;
        }

        //Get by ID
        @GetMapping("/id/{id}")
        public Optional<EmployeeEntity> greetById(@PathVariable Long id){
                return service.findById(id);
        }

        //get all the data
        @GetMapping("/all")
        public List<EmployeeEntity> findAllData() {
                return service.findAllData();
        }
        //Edit or Update the data by id
        @PutMapping("/edit/{id}")
        public EmployeeEntity editGreeting(@RequestBody EmployeeEntity empData, @PathVariable long id) {
                return service.editData(empData, id);
        }

        //Delete the data by id
        @DeleteMapping("/delete/{id}")
        public String deleteGreeting(@PathVariable Long id) {
                service.deleteData(id);
                return "Employee Data deleted";
        }
}
