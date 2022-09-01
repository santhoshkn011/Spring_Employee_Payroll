package com.example.springemployeepayroll;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.thymeleaf.spring5.processor.SpringOptionInSelectFieldTagProcessor;

@SpringBootApplication
@Slf4j
public class SpringEmployeePayrollApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEmployeePayrollApplication.class, args);
        System.out.println("---------------------------------------");
        log.info("Hello! Welcome to the Employee Payroll Project");
    }
}
