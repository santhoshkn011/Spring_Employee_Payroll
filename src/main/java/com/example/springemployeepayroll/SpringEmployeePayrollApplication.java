package com.example.springemployeepayroll;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringEmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEmployeePayrollApplication.class, args);
        System.out.println("Welcome to the Employee Payroll App.");
    }
}
