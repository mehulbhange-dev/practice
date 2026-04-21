package com.example.practice.service;

import com.example.practice.entity.Employee;
import com.example.practice.record.EmployeeRecord;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    EmployeeRecord createEmployee(EmployeeRecord employee);
    EmployeeRecord getEmployeeById(String id);
    List<EmployeeRecord> getAllEmployees();
    EmployeeRecord deleteEmployee(String employeeId);

}
