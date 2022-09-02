package com.example.springemployeepayroll.controller;

import com.example.springemployeepayroll.dto.EmpDto;
import com.example.springemployeepayroll.dto.ResponseDto;
import com.example.springemployeepayroll.model.EmployeeEntity;
import com.example.springemployeepayroll.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
        @Autowired
        IEmployeeService service;

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
//        //Insert Employee Data
//        @PostMapping("/post")
//        public EmployeeEntity addEmpData(@RequestBody EmployeeEntity empData) {
//                return service.saveData(empData);
//        }
//        //Get by ID
//        @GetMapping("/id/{id}")
//        public Optional<EmployeeEntity> getById(@PathVariable Long id){
//                return service.findById(id);
//        }
//
//        //get all the data
//        @GetMapping("/all")
//        public List<EmployeeEntity> findAllData() {
//                return service.findAllData();
//        }
//        //Edit or Update the data by id
//        @PutMapping("/edit/{id}")
//        public EmployeeEntity editData(@RequestBody EmployeeEntity empData, @PathVariable long id) {
//                return service.editData(empData, id);
//        }
//
//        //Delete the data by id
//        @DeleteMapping("/delete/{id}")
//        public String deleteData(@PathVariable Long id) {
//                service.deleteData(id);
//                return "Employee Data deleted";
//        }

        //Insert Employee Data
        @PostMapping("/post")
        public ResponseEntity<ResponseDto> addEmpData(@Valid @RequestBody EmpDto empData) {
                EmployeeEntity response = service.saveData(empData);
                ResponseDto dtoResponse = new ResponseDto("Data Added Successfully", Optional.ofNullable(response));
                return new ResponseEntity<>(dtoResponse, HttpStatus.CREATED);
        }
        //Get by ID
        @GetMapping("/id/{id}")
        public ResponseEntity<ResponseDto> getEmpData(@PathVariable Long id) {
                Optional<EmployeeEntity> empData= service.findById(id);
                ResponseDto respDTO= new ResponseDto("Employee details by ID", empData);
                return new ResponseEntity<>(respDTO, HttpStatus.OK);
        }
        //get all the data
        @GetMapping("/all")
        public ResponseEntity<ResponseDto> findAllData() {
                List<EmployeeEntity> empDatalist = service.findAllData();
                ResponseDto respDTO = new ResponseDto("All Employee Data", empDatalist);
                return new ResponseEntity<>(respDTO, HttpStatus.OK);
        }
        //Edit or Update the data by id
        @PutMapping("/edit/{id}")
        public ResponseEntity<ResponseDto> updateEmpData(@PathVariable Long id,@Valid @RequestBody EmpDto empDto) {
                Optional<EmployeeEntity> empData = Optional.ofNullable(service.editData(empDto, id));
                ResponseDto respDTO= new ResponseDto("Data Update info", empData);
                return new ResponseEntity<>(respDTO, HttpStatus.OK);
        }
        //Delete the data by id
        @DeleteMapping("/delete/{id}")
        public ResponseEntity <ResponseDto> deleteEmpData(@PathVariable Long id) {
                service.deleteData(id);
                ResponseDto respDTO= new ResponseDto("Deleted Successfully", "Deleted id: " + id);
                return new ResponseEntity<>(respDTO, HttpStatus.OK);
        }

        @GetMapping("/department/{department}")
        public ResponseEntity <ResponseDto> getEmployeeDataByDepartment(@PathVariable String department) {
                List<EmployeeEntity> empDataList = service.getEmployeesByDepartment(department);
                ResponseDto respDTO = new ResponseDto("Get Data By Department", empDataList);
                return new ResponseEntity<>(respDTO, HttpStatus.OK);
        }
}
