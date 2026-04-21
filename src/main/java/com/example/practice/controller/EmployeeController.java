package com.example.practice.controller;

import com.example.practice.record.EmployeeRecord;
import com.example.practice.record.Response;
import com.example.practice.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("employees")
    public ResponseEntity<Response<EmployeeRecord>> createEmployee(@Valid @RequestBody EmployeeRecord employeeRecord){
        Response<EmployeeRecord> response =  new Response<EmployeeRecord>(this.employeeService.createEmployee(employeeRecord), true, HttpStatus.OK.value(), null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping("employees/{id}")
    public ResponseEntity<Response<EmployeeRecord>> getEmployeeById(@PathVariable("id") String id){
        Response<EmployeeRecord> response =  new Response<EmployeeRecord>(this.employeeService.getEmployeeById(id), true, HttpStatus.OK.value(), null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }

    @GetMapping("employees")
    public ResponseEntity<Response<List<EmployeeRecord>>> getAllEmployees(){
        Response<List<EmployeeRecord>> response = new Response<>(this.employeeService.getAllEmployees(),true, HttpStatus.OK.value(), null, LocalDateTime.now());
        return ResponseEntity.ok(response);
    }
}
