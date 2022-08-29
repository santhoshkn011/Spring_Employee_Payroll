package com.example.springemployeepayroll.controller;

import com.example.springemployeepayroll.model.EmployeeEntity;
import com.example.springemployeepayroll.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

        @PostMapping("/post")
        public EmployeeEntity addEmpData(@RequestBody EmployeeEntity empData) {
                service.saveData(empData);
                return empData;
        }
}
